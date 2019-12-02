package com.example.projeto.resource;

import com.example.projeto.Distribuir;
import com.example.projeto.models.ClienteDto;
import com.example.projeto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteRepository cr;

    @Autowired
    private Distribuir d;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<ClienteDto> lista()
    {
        Iterable<ClienteDto> listas = cr.findAll();
        return listas;
    }

    @PostMapping()
    public boolean incluir(@RequestBody ClienteDto clienteDto) throws ParseException {
        if (clienteDto.getClienteId() == null && cr.existsByCnpj(clienteDto.getCnpj())) {
            return false;
        } else {
            cr.save(clienteDto);
            return true;
        }
    }

//    @PostMapping("update/")
//    public boolean update(@RequestBody ClienteDto clienteDto)
//    {
//            cr.save(clienteDto);
//            return true;
//    }

    @DeleteMapping("/delete/{id}")
    public void excluir(@PathVariable  Long id)
    {
        cr.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<ClienteDto> buscar(@PathVariable(value = "id") long id)
    {
          return cr.findById(id);
    }

    @GetMapping("/gerenciar/distribuir")
    public List<ClienteDto> gerenciar()
    {
        return d.associarVendedores();
    }
}
