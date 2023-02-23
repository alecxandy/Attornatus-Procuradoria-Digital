package com.alexandre.gerenciamento.de.pessoas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "logradouro")
    @NotBlank(message = "Campo logradouro não informado")
    private String logradouro;

    @Column(name = "cep")
    @NotBlank(message = "Campo cep não informado")
    private String cep;

    @Column(name = "numero")
    @NotBlank(message = "Campo numero não informado")
    private int numero;

    @Column(name = "cidade")
    @NotBlank(message = "Campo cidade não informado")
    private String cidade;


}
