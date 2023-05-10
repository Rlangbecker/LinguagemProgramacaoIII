package com.vendaingressos.vendaingressos.controller;

import com.vendaingressos.vendaingressos.dto.compra.CompraOutputInputDTO;
import com.vendaingressos.vendaingressos.entity.enums.TipoIngresso;
import com.vendaingressos.vendaingressos.service.VendaIngressoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendas-ingresso")
public class VendaIngressoController {
    private final VendaIngressoService vendaIngressoService;

    @PostMapping
    public ResponseEntity<CompraOutputInputDTO> create(@RequestParam Integer idCliente, @RequestParam TipoIngresso ingresso) {
        CompraOutputInputDTO compraRetorno = vendaIngressoService.getCalcularVendaIngresso(ingresso, idCliente, ingresso.getStrategy());
        return new ResponseEntity<>(compraRetorno, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<String>> getTiposIngresso() {
        List<String> tiposIngresso = vendaIngressoService.getTiposIngresso();
        return new ResponseEntity<>(tiposIngresso, HttpStatus.OK);
    }

    @GetMapping("ingressos-vendidos")
    public ResponseEntity<List<CompraOutputInputDTO>> getIngressosVendidos() {
        List<CompraOutputInputDTO> ingressosVendidos = vendaIngressoService.getIngressosVendidos();
        return new ResponseEntity<>(ingressosVendidos, HttpStatus.OK);
    }
}
