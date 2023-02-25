package com.alexandre.gerenciamento.de.pessoas.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Long id;
    @NotBlank(message = "Campo nome não informado")
    private String nome;

    @NotBlank(message = "Campo data de nascimento não informado")
    private LocalDate dataNascimento;
    @NotBlank(message = "Campo endereço não informado")
    private Long endereco;

}
