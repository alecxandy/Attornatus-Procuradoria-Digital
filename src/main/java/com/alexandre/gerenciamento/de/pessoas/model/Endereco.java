package com.alexandre.gerenciamento.de.pessoas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "logradouro")
    @NotNull(message = "Preencher logradouro")
    private String logradouro;

    @Column(name = "cep")
    @NotNull(message = "Preencher cep")
    private String cep;

    @Column(name = "numero")
    @NotNull(message = "Preencher numero")
    private int numero;

    @Column(name = "cidade")
    @NotNull(message = "Preencher cidade")
    private String cidade;

}
