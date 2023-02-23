package com.alexandre.gerenciamento.de.pessoas.controller;

import com.alexandre.gerenciamento.de.pessoas.model.Endereco;
import com.alexandre.gerenciamento.de.pessoas.model.Pessoa;
import com.alexandre.gerenciamento.de.pessoas.model.dto.PessoaDTO;
import com.alexandre.gerenciamento.de.pessoas.service.EnderecoService;
import com.alexandre.gerenciamento.de.pessoas.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody @Valid PessoaDTO pessoaDTO) {
        Endereco endereco = enderecoService.findById(pessoaDTO.getEndereco())
                .orElseThrow(() -> new RuntimeException("id does not exist"));
        Pessoa p = new Pessoa();
        p.setNome(pessoaDTO.getNome());
        p.setEndereco(endereco);
        p.setDataNascimento(pessoaDTO.getDataNascimento());
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(p));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist"));
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        pessoaService.findById(id).map(pessoa -> {
            pessoaService.deleteById(id);
            return pessoa;
        }).orElseThrow(() -> new RuntimeException("id does not exist"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) {
        Endereco endereco = enderecoService.findById(pessoaDTO.getEndereco())
                .orElseThrow(() -> new RuntimeException("id does not exist"));
        Pessoa pessoa = pessoaService.findById(id).map(p -> {
            p.setId(id);
            p.setDataNascimento(pessoaDTO.getDataNascimento());
            p.setEndereco(endereco);
            p.setNome(pessoaDTO.getNome());
            return p;
        }).orElseThrow(() -> new RuntimeException("id does not exist"));
    return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

}
