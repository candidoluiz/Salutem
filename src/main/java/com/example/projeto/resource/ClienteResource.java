package com.example.projeto.resource;

import com.example.projeto.models.ClienteDto;
import com.example.projeto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteRepository cr;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<ClienteDto> lista()
    {
        Iterable<ClienteDto> listas = cr.findAll();
        return listas;
    }

    @PostMapping()
    public ClienteDto incluir(@RequestBody ClienteDto clienteDto)
    {
        return cr.save(clienteDto);
    }

    @DeleteMapping()
    public void excluir(@RequestBody ClienteDto clienteDto)
    {
        cr.delete(clienteDto);
    }
}
