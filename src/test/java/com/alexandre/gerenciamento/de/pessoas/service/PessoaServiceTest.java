package com.alexandre.gerenciamento.de.pessoas.service;

import com.alexandre.gerenciamento.de.pessoas.model.Endereco;
import com.alexandre.gerenciamento.de.pessoas.model.Pessoa;
import com.alexandre.gerenciamento.de.pessoas.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    Endereco endereco = new Endereco(1L, "R.dois", "50650000", 23, "Recife");
    Pessoa pessoa = new Pessoa(1L, "alexandre", LocalDate.now(), endereco);

    @Test
    public void crearPessoa_validarDados_retornaPessoa() {
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);
        Pessoa sut = pessoaService.save(pessoa);
        assertThat(sut).isEqualTo(pessoa);
    }

    @Test
    public void listarPessoas_retornaListaDepessoas() {
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(pessoa);
        when(pessoaRepository.findAll()).thenReturn(pessoaList);
        List<Pessoa> sut = pessoaService.findAll();
        assertThat(sut).isEqualTo(pessoaList);
    }


}
