package com.example.projeto.repository;

import com.example.projeto.models.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioDto, Long> {

}
