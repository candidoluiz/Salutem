package com.example.projeto.models;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioDto {

    @Id
    @Column(name = "usuarioId")
    @GeneratedValue
    private  Long usuarioId;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "senha")
    private String senha;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
