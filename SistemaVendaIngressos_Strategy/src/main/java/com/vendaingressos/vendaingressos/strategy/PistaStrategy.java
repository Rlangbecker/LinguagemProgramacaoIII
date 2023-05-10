package com.vendaingressos.vendaingressos.strategy;

import com.vendaingressos.vendaingressos.entity.ClienteEntity;
import com.vendaingressos.vendaingressos.entity.enums.TipoIngresso;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PistaStrategy implements VendaIngressoStrategy {

    private static final BigDecimal DESCONTO_PORCENTAGEM_PISTAS = new BigDecimal(50);
    private static final BigDecimal TOTAL_PORCENTAGEM = new BigDecimal(100);

    @Value("${idade.idoso}")
    private int idadeIdoso;

    @Override
    public BigDecimal vender(TipoIngresso tipoIngresso, ClienteEntity clienteEntity) {
        long idade = ChronoUnit.YEARS.between(clienteEntity.getDataNascimento(), LocalDate.now());

        if (clienteEntity.getIsEstudante() || idade >= idadeIdoso) {
            return tipoIngresso.getValor()
                    .divide(TOTAL_PORCENTAGEM)
                    .multiply(DESCONTO_PORCENTAGEM_PISTAS);
        } else {
            return tipoIngresso.getValor();
        }
    }
}
