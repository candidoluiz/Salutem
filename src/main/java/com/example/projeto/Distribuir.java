package com.example.projeto;

import com.example.projeto.models.ClienteDto;
import com.example.projeto.repository.ClienteRepository;
import com.example.projeto.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Distribuir {
    @Autowired
    private ClienteRepository cr;

    @Autowired
    private VendedorRepository vr;

    public   List<ClienteDto> associarVendedores() {

        for (ClienteDto cliente : cr.findAll()) {
            cliente.associarVendedorMaisProximo(vr.findAll());

            System.out.println("O Cliente : " + cliente.getClienteId() + " -  tem o vendedor mais próximo: " + cliente.getVendedorDto().getNome() + " na distância de : " + cliente.getDistancia() + "Km");
            cr.save(cliente);
        }
        return cr.findAll();
    }

}
