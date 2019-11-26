package com.example.projeto.repository;

import com.example.projeto.models.VendedorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorDto, Long> {
    boolean findVendedorCpf(String cpf);
}
