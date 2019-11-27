package com.example.projeto.resource;

import com.example.projeto.models.ClienteDto;
import com.example.projeto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;

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
    public boolean incluir(@RequestBody ClienteDto clienteDto) throws ParseException {
     //   if (!cr.existsByCnpj(clienteDto.getCnpj()))
      //  {
            cr.save(clienteDto);
            return true;
      //  }else{
       //     return false;
      //  }

    }
//     @PostMapping("/{id}")
//    public boolean update(@RequestBody ClienteDto clienteDto)
//    {
//            cr.save(clienteDto);
//            return true;
//    }

    @DeleteMapping()
    public void excluir(@RequestBody ClienteDto clienteDto)
    {
        cr.delete(clienteDto);
    }

    @GetMapping("/{id}")
    public Optional<ClienteDto> buscar(@PathVariable(value = "id") long id)
    {
          return cr.findById(id);
    }
}
