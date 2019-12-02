package com.example.projeto;

import com.example.projeto.resource.ClienteResource;
import com.example.projeto.resource.VendedorResource;

public class Distribuir {

    ClienteResource cr = new ClienteResource();
    VendedorResource vr = new VendedorResource();

//    public  List<ClienteDto> gerencial()
//    {
//        List<ClienteDto> listaC = cr.lista();
//        List<VendedorDto> listaV = vr.lista();
//
//        for (int i = 0; i < listaC.size(); i++)
//        {
//            for (int j = 0; j < listaV.size()-1; j++)
//            {
//                if (LatLong.distancia(
//                        Double.parseDouble(listaC.get(i).getLat()),
//                        Double.parseDouble(listaC.get(i).getLongi()),
//                        Double.parseDouble(listaV.get(j).getLat()),
//                        Double.parseDouble(listaV.get(j).getLongi()))
//                        <
//                        LatLong.distancia(
//                        Double.parseDouble(listaC.get(i).getLat()),
//                        Double.parseDouble(listaC.get(i).getLongi()),
//                        Double.parseDouble(listaV.get(j+1).getLat()),
//                        Double.parseDouble(listaV.get(j+1).getLongi())))
//
//                {
//                    listaC.get(i).setVendedorDto(listaV.get(j));
//                    listaC.get(i).setDistancia(LatLong.distancia(
//                            Double.parseDouble(listaC.get(i).getLat()),
//                            Double.parseDouble(listaC.get(i).getLongi()),
//                            Double.parseDouble(listaV.get(j).getLat()),
//                            Double.parseDouble(listaV.get(j).getLongi())));
//                }
//            }
//        }
//
//        return listaC;
//
//    }
}
