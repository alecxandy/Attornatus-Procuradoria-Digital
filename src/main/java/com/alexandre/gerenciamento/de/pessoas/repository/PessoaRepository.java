package com.alexandre.gerenciamento.de.pessoas.repository;

import com.alexandre.gerenciamento.de.pessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
