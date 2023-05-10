package com.vendaingressos.vendaingressos.strategy;

import com.vendaingressos.vendaingressos.entity.ClienteEntity;
import com.vendaingressos.vendaingressos.entity.enums.TipoIngresso;

import java.math.BigDecimal;

public class CamaroteStrategy implements VendaIngressoStrategy {

    @Override
    public BigDecimal vender(TipoIngresso tipoIngresso, ClienteEntity clienteEntity) {
        return tipoIngresso.getValor();
    }
}
