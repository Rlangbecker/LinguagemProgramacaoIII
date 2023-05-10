package com.vendaingressos.vendaingressos.entity.enums;

import com.vendaingressos.vendaingressos.strategy.*;

import java.math.BigDecimal;

public enum TipoIngresso {
    PISTA(new BigDecimal(250), new PistaStrategy()),
    PISTA_PREMIUM(new BigDecimal(400), new PistaPremiumStrategy()),
    CAMAROTE(new BigDecimal(750), new CamaroteStrategy()),
    CADEIRA_INFERIOR(new BigDecimal(200), new CadeiraInferiorStrategy()),
    CADEIRA_SUPERIOR(new BigDecimal(150), new CadeiraSuperiorStrategy());

    private final VendaIngressoStrategy strategy;
    private BigDecimal valor;

    private TipoIngresso(BigDecimal valor, VendaIngressoStrategy strategy) {
        this.valor = valor;
        this.strategy = strategy;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public VendaIngressoStrategy getStrategy() {
        return strategy;
    }
}
