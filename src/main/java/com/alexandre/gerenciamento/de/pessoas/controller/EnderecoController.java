package com.alexandre.gerenciamento.de.pessoas.controller;

import com.alexandre.gerenciamento.de.pessoas.exceptions.NotFoundException;
import com.alexandre.gerenciamento.de.pessoas.model.Endereco;
import com.alexandre.gerenciamento.de.pessoas.service.EnderecoService;
import jakarta.persistence.EntityResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @PostMapping
    public ResponseEntity<Long> save(@RequestBody @Valid Endereco endereco) {
        Endereco end = enderecoService.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(end.getId());
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id) {
        Endereco endereco = enderecoService.findById(id)
                .orElseThrow(() -> new NotFoundException("id does not exist"));
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        enderecoService.findById(id).map(endereco -> {
            enderecoService.deleteById(id);
            return endereco;
        }).orElseThrow(() -> new NotFoundException("id does not exist"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody  @Valid Endereco endereco) {
        Endereco endereco1 = enderecoService.findById(id).map(e -> {
            e.setId(id);
            e.setCep(endereco.getCep());
            e.setCidade(endereco.getCidade());
            e.setNumero(endereco.getNumero());
            e.setLogradouro(endereco.getLogradouro());
            enderecoService.save(e);
            return e;
        }).orElseThrow(() -> new NotFoundException("id does not exist"));
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }


}
