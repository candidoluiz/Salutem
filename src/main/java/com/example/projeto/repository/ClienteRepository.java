package com.example.projeto.repository;

import com.example.projeto.models.ClienteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository  extends JpaRepository<ClienteDto, Long> {
    boolean existsByCnpj(String cnpj);

    List<ClienteDto> findClienteDtosByClienteIdAndRazaoSocial(Long id, String razaoSocial);
    List<ClienteDto> findByOrderByClienteIdAsc();

}
