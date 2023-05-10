package com.vendaingressos.vendaingressos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vendaingressos.vendaingressos.dto.cliente.ClienteOutputDTO;
import com.vendaingressos.vendaingressos.dto.compra.CompraOutputInputDTO;
import com.vendaingressos.vendaingressos.entity.ClienteEntity;
import com.vendaingressos.vendaingressos.entity.CompraEntity;
import com.vendaingressos.vendaingressos.entity.enums.TipoIngresso;
import com.vendaingressos.vendaingressos.repository.VendaIngressoRepository;
import com.vendaingressos.vendaingressos.strategy.VendaIngressoStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendaIngressoService {

    private final VendaIngressoRepository vendaIngressoRepository;
    private final ClienteService clienteService;

    private final ObjectMapper objectMapper;

    public CompraOutputInputDTO getCalcularVendaIngresso(TipoIngresso tipoIngresso, Integer id, VendaIngressoStrategy strategy) {

        ClienteOutputDTO clienteOutputDTO = clienteService.findById(id);

        ClienteEntity clienteEntity = objectMapper.convertValue(clienteOutputDTO, ClienteEntity.class);

        BigDecimal valor = tipoIngresso.getStrategy().vender(tipoIngresso, clienteEntity);

        CompraEntity compra = new CompraEntity();
        compra.setTipoIngresso(tipoIngresso);
        compra.setClienteEntity(clienteEntity);
        compra.setValor(valor);

        CompraOutputInputDTO compraOutputDTO = vendaIngressoRepository.comprarIngresso(compra);
        compraOutputDTO.setValor(valor);

        return compraOutputDTO;
    }

    public List<String> getTiposIngresso() {
        List tiposIngresso = new ArrayList<>();

        tiposIngresso.add(TipoIngresso.PISTA.toString());
        tiposIngresso.add(TipoIngresso.PISTA_PREMIUM.toString());
        tiposIngresso.add(TipoIngresso.CADEIRA_SUPERIOR.toString());
        tiposIngresso.add(TipoIngresso.CADEIRA_INFERIOR.toString());
        tiposIngresso.add(TipoIngresso.CAMAROTE.toString());

        return tiposIngresso;
    }

    public List<CompraOutputInputDTO> getIngressosVendidos() {
        return vendaIngressoRepository.getIngressosVendidos().stream()
                .map(compra -> objectMapper.convertValue(compra, CompraOutputInputDTO.class))
                .collect(Collectors.toList());
    }
}
