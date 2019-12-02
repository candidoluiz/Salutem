package com.example.projeto;

import com.example.projeto.models.ClienteDto;
import com.example.projeto.models.VendedorDto;
import com.example.projeto.repository.ClienteRepository;
import com.example.projeto.repository.VendedorRepository;
import com.example.projeto.resource.ClienteResource;
import com.example.projeto.resource.VendedorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class Distribuir {
ClienteDto c = new ClienteDto();
    @Autowired
    private ClienteRepository cr;

    @Autowired
    private VendedorRepository vr;

    public   List<ClienteDto> associarVendedores() {

        for (ClienteDto cliente : cr.findAll()) {
            List<DistribuicaoDTO> distribuicoes = new ArrayList<>();
            for (VendedorDto vendedor : vr.findAll()) {
                distribuicoes.add(
                new DistribuicaoDTO(cliente, vendedor, LatLong.distancia(
                        Double.parseDouble(cliente.getLat()),
                        Double.parseDouble(cliente.getLongi()),
                        Double.parseDouble(vendedor.getLat()),
                        Double.parseDouble(vendedor.getLongi()))));
            }
            Collections.sort(distribuicoes, Comparator.comparingDouble(DistribuicaoDTO::getDistancia));

            cliente.setVendedorDto(distribuicoes.get(0).getVendedor());
            cliente.setDistancia(Double.toString(distribuicoes.get(0).getDistancia()));

            System.out.println("O Cliente : " + cliente.getClienteId() + " - " + cliente.getNome() + " tem o vendedor mais próximo: " + cliente.getVendedorDto().getNome() + " na distância de : " + cliente.getDistancia() + "Km");
            cr.save(cliente);
        }
        return cr.findAll();
    }



    class DistribuicaoDTO {
        private ClienteDto cliente;
        private VendedorDto vendedor;
        private Double distancia;

        DistribuicaoDTO(ClienteDto cliente, VendedorDto vendedor, Double distancia) {
            this.cliente = cliente;
            this.vendedor = vendedor;
            this.distancia = distancia;
        }

        public ClienteDto getCliente() {
            return cliente;
        }

        public Double getDistancia() {
            return distancia;
        }

        public VendedorDto getVendedor() {
            return vendedor;
        }
    }
}
