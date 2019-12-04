package com.example.projeto.resource;

import com.example.projeto.models.VendedorDto;
import com.example.projeto.repository.VendedorRepository;
import com.example.projeto.exceptions.CpfCnpjException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/vendedor")
public class VendedorResource {

    VendedorDto vendedorDto;

    @Autowired
    private VendedorRepository vr;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<VendedorDto> lista()
    {
         Iterable<VendedorDto> listas = vr.findAll();
        return listas;
    }

    @PostMapping()
    public boolean incluir(@RequestBody VendedorDto vendedor) throws CpfCnpjException {
       if (vendedor.getVendedorId()==null && vr.existsByCpf(vendedor.getCpf()))
       {
            throw new CpfCnpjException(vendedor.getCpf(), vendedor.getVendedorId());

       }else{
           vendedorDto = new VendedorDto(
                   vendedor.getNome(),
                   vendedor.getCpf(),
                   vendedor.getLat(),
                   vendedor.getLongi(),
                   vendedor.getVendedorId());

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
