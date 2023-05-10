package com.vendaingressos.vendaingressos.dto.compra;

import com.vendaingressos.vendaingressos.entity.ClienteEntity;
import com.vendaingressos.vendaingressos.entity.enums.TipoIngresso;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CompraInputDTO {

    @NotNull
    private TipoIngresso tipoIngresso;

    @NotNull
    private ClienteEntity clienteEntity;
}
