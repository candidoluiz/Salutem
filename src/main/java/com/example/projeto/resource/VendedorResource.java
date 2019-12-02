package com.example.projeto.resource;

import com.example.projeto.models.VendedorDto;
import com.example.projeto.repository.VendedorRepository;
import com.example.projeto.utilitario.CpfCnpjException;
import com.example.projeto.utilitario.CpfCnpjUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/vendedor")
public class VendedorResource {

    @Autowired
    private VendedorRepository vr;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<VendedorDto> lista()
    {
         Iterable<VendedorDto> listas = vr.findAll();
        return listas;
    }

    @PostMapping()
    public boolean incluir(@RequestBody VendedorDto vendedorDto) {
       if (vendedorDto.getVendedorId()==null && vr.existsByCpf(vendedorDto.getCpf()))
       {
           return false;
       }else{
             vr.save(vendedorDto);
             return true;
       }



    }

    @DeleteMapping("/delete/{id}")
    public void excluir(@PathVariable  Long id)
    {
        vr.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<VendedorDto> buscar(@PathVariable(value = "id") long id)
    {
          return vr.findById(id);
    }

}
