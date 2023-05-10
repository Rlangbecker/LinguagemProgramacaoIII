package com.vendaingressos.vendaingressos.dto.cliente;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteOutputDTO {

    private Integer idCliente;
    private String nome;
    private LocalDate dataNascimento;

    private Boolean isEstudante;
}
