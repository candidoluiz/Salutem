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
import java.util.List;

@Service
public class Distribuir {
ClienteDto c = new ClienteDto();
    @Autowired
    private ClienteRepository cr;

    @Autowired
    private VendedorRepository vr;

    public   List<ClienteDto> gerencial()
    {
        List<ClienteDto> listaC = cr.findAll();
        List<VendedorDto> listaV = vr.findAll();
        List<ClienteDto> aux = new ArrayList<>();


        for (int i = 0; i < listaC.size(); i++)
        {
            for (int j = 0; j < listaV.size()-1; j++)
            {
                if (LatLong.distancia(
                        Double.parseDouble(listaC.get(i).getLat()),
                        Double.parseDouble(listaC.get(i).getLongi()),
                        Double.parseDouble(listaV.get(j).getLat()),
                        Double.parseDouble(listaV.get(j).getLongi()))
                        >
                        LatLong.distancia(
                        Double.parseDouble(listaC.get(i).getLat()),
                        Double.parseDouble(listaC.get(i).getLongi()),
                        Double.parseDouble(listaV.get(j+1).getLat()),
                        Double.parseDouble(listaV.get(j+1).getLongi())))

                {

                    ClienteDto c = listaC.get(i);
                    VendedorDto v = listaV.get(j);


                    c.setVendedorDto(v);
                    aux.add(c);


                  // listaC.get(i).setVendedorDto(listaV.get(j));

//                    listaC.get(i).setDistancia(LatLong.distancia(
//                            Double.parseDouble(listaC.get(i).getLat()),
//                            Double.parseDouble(listaC.get(i).getLongi()),
//                            Double.parseDouble(listaV.get(j).getLat()),
//                            Double.parseDouble(listaV.get(j).getLongi())));
                }
            }
        }


        return aux;

    }
}
