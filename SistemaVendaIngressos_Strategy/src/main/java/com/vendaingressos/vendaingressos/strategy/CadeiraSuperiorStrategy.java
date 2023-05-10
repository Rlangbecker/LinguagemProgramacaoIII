package com.vendaingressos.vendaingressos.strategy;

import com.vendaingressos.vendaingressos.entity.ClienteEntity;
import com.vendaingressos.vendaingressos.entity.enums.TipoIngresso;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CadeiraSuperiorStrategy implements VendaIngressoStrategy {

    private static final BigDecimal DESCONTO_PORCENTAGEM_CADEIRAS_ESTUDANTE = new BigDecimal(50);
    private static final BigDecimal DESCONTO_PORCENTAGEM_CADEIRAS_IDOSO = new BigDecimal(60);
    private static final BigDecimal TOTAL_PORCENTAGEM = new BigDecimal(100);

    @Value("${idade.idoso}")
    private int idadeIdoso;

    @Override
    public BigDecimal vender(TipoIngresso tipoIngresso, ClienteEntity clienteEntity) {
        long idade = ChronoUnit.YEARS.between(clienteEntity.getDataNascimento(), LocalDate.now());

        Boolean clienteIsEstudante = clienteEntity.getIsEstudante();
        if (clienteIsEstudante && idade >= idadeIdoso) {
            return tipoIngresso.getValor()
                    .divide(TOTAL_PORCENTAGEM)
                    .multiply(DESCONTO_PORCENTAGEM_CADEIRAS_IDOSO);
        } else if (clienteIsEstudante && idade < idadeIdoso) {
            return tipoIngresso.getValor()
                    .divide(TOTAL_PORCENTAGEM)
                    .multiply(DESCONTO_PORCENTAGEM_CADEIRAS_ESTUDANTE);
        } else if (!clienteIsEstudante && idade >= idadeIdoso) {
            return tipoIngresso.getValor()
                    .divide(TOTAL_PORCENTAGEM)
                    .multiply(DESCONTO_PORCENTAGEM_CADEIRAS_IDOSO);
        } else {
            return tipoIngresso.getValor();
        }
    }
}
