package com.alexandre.gerenciamento.de.pessoas.service;


import com.alexandre.gerenciamento.de.pessoas.model.Endereco;
import com.alexandre.gerenciamento.de.pessoas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findById(Long id) {
        return enderecoRepository.findById(id);
    }

    public void deleteById(Long id) {
        enderecoRepository.deleteById(id);
    }
}
