package com.alexandre.gerenciamento.de.pessoas.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Long id;
    @NotNull(message = "Preencher nome")
    private String nome;
    @NotNull(message = "Preencher data de nascimento")
    private LocalDate dataNascimento;
    private Long endereco;

}
