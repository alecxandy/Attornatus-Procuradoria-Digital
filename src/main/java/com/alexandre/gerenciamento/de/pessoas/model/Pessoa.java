package com.alexandre.gerenciamento.de.pessoas.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Campo nome não informado")
    private String nome;

    @Column(name = "data_nasc")
    @NotBlank(message = "Campo data de nascimento não informado")
    private LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    @NotBlank(message = "Campo endereço não informado")
    private Endereco endereco;
}
