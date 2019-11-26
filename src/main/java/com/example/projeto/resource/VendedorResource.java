package com.example.projeto.resource;

import com.example.projeto.models.VendedorDto;
import com.example.projeto.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public boolean incluir(@RequestBody VendedorDto vendedorDto)
    {
        if (!vr.findVendedorCpf(vendedorDto.getCpf()))
        {
            vr.save(vendedorDto);
            return true;
        }else{
            return false;
        }


    }

    @DeleteMapping()
    public void excluir(VendedorDto vendedorDto)
    {
        vr.delete(vendedorDto);
    }



}
