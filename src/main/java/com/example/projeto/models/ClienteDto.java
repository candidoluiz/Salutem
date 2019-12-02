package com.example.projeto.models;

import com.example.projeto.Mascara;

import javax.persistence.*;
import java.text.ParseException;

@Entity
@Table(name = "cliente")
public class ClienteDto {

    @Id
    @Column(name = "clienteid")
    @GeneratedValue
    private Long clienteId;

    @Column(name = "nome")
    private String nome;

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

    public String getNome() {
        return nome;
    }

    public String getCnpj()  {
       return Mascara.formatCnpj(cnpj);

    }

    public String getRazaoSocial() throws ParseException {
       return razaoSocial;
    }

    public String getLat() {
        return lat;
    }

    public String getLongi() {
        return longi;
    }

    public VendedorDto getVendedorDto() {
        return vendedorDto;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

}
