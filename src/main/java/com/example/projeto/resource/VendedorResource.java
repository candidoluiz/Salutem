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
    public VendedorDto incluir(@RequestBody VendedorDto vendedorDto) {
//        try {
//            VendedorDto novoVendedor = new VendedorDto(vendedorDto.getNome(), vendedorDto.getCpf(), vendedorDto.getLat(), vendedorDto.getLongi(), vendedorDto.getVendedorId());
//            return ResponseEntity.status(HttpStatus.CREATED).body(vr.save(novoVendedor).getVendedorId());
//        } catch (ConstraintViolationException cex) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("O CPF " + vendedorDto.getCpf() + " já existe");
//        } catch ( CpfCnpjException e ) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch ( Exception e ) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }

    return vr.save(vendedorDto);
        /*if (!vr.existsByCpf(vendedorDto.getCpf()))
        {
            VendedorDto novoVendedor = new VendedorDto(vendedorDto.getNome(), vendedorDto.getCpf(), vendedorDto.getLat(), vendedorDto.getLongi());
            novoVendedor = vr.save(vendedorDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoVendedor.getVendedorId());
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O CPF " + vendedorDto.getCpf() + " já existe");
        }*/
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
