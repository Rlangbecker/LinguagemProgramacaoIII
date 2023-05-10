package com.vendaingressos.vendaingressos.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vendaingressos.vendaingressos.dto.compra.CompraOutputInputDTO;
import com.vendaingressos.vendaingressos.entity.CompraEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class VendaIngressoRepository {

    private List<CompraEntity> ingressosVendidos = new ArrayList<>();

    private static Long id = 0l;

    private final ObjectMapper objectMapper;

    public CompraOutputInputDTO comprarIngresso(CompraEntity compra) {
        id++;
        compra.setIdCompra(id);
        ingressosVendidos.add(compra);
        return objectMapper.convertValue(compra, CompraOutputInputDTO.class);
    }

    public List<CompraEntity> getIngressosVendidos() {
        return ingressosVendidos;
    }

}
