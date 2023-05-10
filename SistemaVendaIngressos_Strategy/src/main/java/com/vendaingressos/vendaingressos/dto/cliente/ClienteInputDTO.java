package com.vendaingressos.vendaingressos.dto.cliente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteInputDTO {

    @Schema(example = "Ricardo", description = "Nome do cliente")
    private String nome;
    @Schema(example = "1920-07-03", description = "Data de nascimento do ClienteEntity")
    private LocalDate dataNascimento;

    @Schema(example = "true", description = "true se for estudante, false se não for")
    private Boolean isEstudante;
}
