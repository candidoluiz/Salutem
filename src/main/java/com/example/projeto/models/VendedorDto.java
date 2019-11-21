package com.example.projeto.models;

import javax.persistence.*;

@Entity
@Table(name = "vendedor")
public class VendedorDto {

    @Id
    @Column(name = "vendedorid")
    @GeneratedValue
    private Long vendedorId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "lat")
    private String lat;

    @Column(name = "longi")
    private String longi;

    public Long getVendedorId() {
        return vendedorId;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getLat() {
        return lat;
    }

    public String getLongi() {
        return longi;
    }
}
