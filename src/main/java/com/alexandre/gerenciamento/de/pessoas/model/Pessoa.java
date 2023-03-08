package com.alexandre.gerenciamento.de.pessoas.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    @NotNull(message = "Preencher nome")
    private String nome;

    @Column(name = "data_nasc")
    @NotNull(message = "Preencher data de nascimento")
    private LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}
