package com.vendaingressos.vendaingressos.strategy;

import com.vendaingressos.vendaingressos.entity.ClienteEntity;
import com.vendaingressos.vendaingressos.entity.enums.TipoIngresso;

import java.math.BigDecimal;

public interface VendaIngressoStrategy {
    BigDecimal vender(TipoIngresso tipoIngresso, ClienteEntity clienteEntity);
}
