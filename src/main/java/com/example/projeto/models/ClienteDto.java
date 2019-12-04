package com.example.projeto.models;

import com.example.projeto.LatLong;
import com.example.projeto.exceptions.CpfCnpjException;
import com.example.projeto.utilitario.CpfCnpjUtils;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "cliente")
public class ClienteDto {

    public ClienteDto(Long clienteId, String cnpj, String razaoSocial, String lat, String longi) throws CpfCnpjException {
        this.clienteId = clienteId;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.lat = lat;
        this.longi = longi;

        if (!CpfCnpjUtils.isValid(this.cnpj))
            throw new CpfCnpjException(this.cnpj);
    }
    public  ClienteDto(Long clienteId){
         this.clienteId = clienteId;
    }

    public ClienteDto(){}

    public ClienteDto(String distancia, VendedorDto vendedorDto){
        this.distancia = distancia;
        this.vendedorDto = vendedorDto;
    }

    @Id
    @Column(name = "clienteid")
    @GeneratedValue
    private Long clienteId;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "razaosocial")
    private String razaoSocial;

    @Column(name = "lat")
    private String lat;

    @Column(name = "longi")
    private String longi;

    @Column(name = "distancia")
    private String distancia;

    @ManyToOne()
    @JoinColumn(name = "vendedorid")
    private VendedorDto vendedorDto;

    public Long getClienteId() {
        return clienteId;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getLat() {
        return lat;
    }

    public String getLongi() {
        return longi;
    }

    public String getDistancia() {
        return distancia;
    }

    public VendedorDto getVendedorDto() {
        return vendedorDto;
    }


    public void associarVendedorMaisProximo(List<VendedorDto> vendedores)
    {
        VendedorDto vendedorMaisProximo = null;
        double distanciaMinima = Double.MAX_VALUE;

        for (VendedorDto vendedor : vendedores) {
            double distanciaLocal = LatLong.distancia(
                        Double.parseDouble(this.lat),
                        Double.parseDouble(this.longi),
                        Double.parseDouble(vendedor.getLat()),
                        Double.parseDouble(vendedor.getLongi()));

            if (distanciaLocal < distanciaMinima) {
                vendedorMaisProximo = vendedor;
                distanciaMinima = distanciaLocal;
            }
        }

        this.vendedorDto = vendedorMaisProximo;
    }



}
