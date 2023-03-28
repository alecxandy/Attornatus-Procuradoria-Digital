package com.alexandre.gerenciamento.de.pessoas.controller;

import com.alexandre.gerenciamento.de.pessoas.exceptions.NotFoundException;
import com.alexandre.gerenciamento.de.pessoas.model.Endereco;
import com.alexandre.gerenciamento.de.pessoas.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @PostMapping
    public ResponseEntity<Long> save(@RequestBody Endereco endereco) {
        Endereco end = enderecoService.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(end.getId());
    }

    //http://localhost:8080/spring-mvc-basics/api/foos?id=1&id=2   examplo de parametro com requestParam
    @GetMapping
    public ResponseEntity<Page<Endereco>> findAll(@RequestParam(name = "x") int x,@RequestParam(name = "y") int y) { //Paginação
        Pageable pageable = PageRequest.of(x, y, Sort.by("cidade"));
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll(pageable));
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
    public ResponseEntity<Endereco> update(@PathVariable Long id, @Valid @RequestBody Endereco endereco) {
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
