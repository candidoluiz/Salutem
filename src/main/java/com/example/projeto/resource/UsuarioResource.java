package com.example.projeto.resource;

import com.example.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticar")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository ur;


}
