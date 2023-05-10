package com.vendaingressos.vendaingressos.entity;

import com.vendaingressos.vendaingressos.entity.enums.TipoIngresso;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class CompraEntity {

    private Long idCompra;
    private TipoIngresso tipoIngresso;

    private ClienteEntity clienteEntity;

    private BigDecimal valor;

}
