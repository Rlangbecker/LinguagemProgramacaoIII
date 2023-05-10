package com.vendaingressos.vendaingressos.dto.compra;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CompraOutputInputDTO extends CompraInputDTO {
    private Long idCompra;

    private BigDecimal valor;
}
