package com.example.projeto.models;

import com.example.projeto.utilitario.CpfCnpjException;
import com.example.projeto.utilitario.CpfCnpjUtils;

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

    VendedorDto(){}

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

    public VendedorDto(String nome, String cpf, String lat, String longi, Long vendedorId) throws CpfCnpjException {
        this.nome = nome;
        this.cpf = cpf;
        this.lat = lat;
        this.longi = longi;
        this.vendedorId = vendedorId;

        if (!CpfCnpjUtils.isValid(this.cpf))
            throw new CpfCnpjException(this.cpf);

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

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
