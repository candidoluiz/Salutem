package com.example.projeto.repository;

import com.example.projeto.models.ClienteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends JpaRepository<ClienteDto, Long> {
    boolean existsByCnpj(String cnpj);

}
