package com.example.projeto.resource;

import com.example.projeto.models.VendedorDto;
import com.example.projeto.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendedor")
public class VendedorResource {

    @Autowired
    private VendedorRepository vr;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<VendedorDto> lista()
    {
         return vr.findAll();
    }

    @PostMapping()
    public VendedorDto incluir(@RequestBody VendedorDto vendedorDto)
    {
        return vr.save(vendedorDto);
    }

    @DeleteMapping()
    public void excluir(VendedorDto vendedorDto)
    {
        vr.delete(vendedorDto);
    }



}
