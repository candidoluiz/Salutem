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

    public String getCnpj() {
        return cnpj;
    }
//    public String getCnpj()  {
//       return Mascara.formatCnpj(cnpj);
//
//    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setVendedorDto(VendedorDto vendedorDto) {
        this.vendedorDto = vendedorDto;
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
