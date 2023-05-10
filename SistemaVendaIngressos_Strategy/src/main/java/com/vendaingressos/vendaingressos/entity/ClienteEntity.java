package com.vendaingressos.vendaingressos.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ClienteEntity {


    private Integer idCliente;
    private String nome;
    private LocalDate dataNascimento;

    private Boolean isEstudante;

}
