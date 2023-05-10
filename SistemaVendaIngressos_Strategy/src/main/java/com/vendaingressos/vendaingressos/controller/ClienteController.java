package com.vendaingressos.vendaingressos.controller;

import com.vendaingressos.vendaingressos.dto.cliente.ClienteInputDTO;
import com.vendaingressos.vendaingressos.dto.cliente.ClienteOutputDTO;
import com.vendaingressos.vendaingressos.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {


    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteOutputDTO> create(@RequestBody ClienteInputDTO clienteInputDTO) {
        ClienteOutputDTO clienteRetorno = clienteService.create(clienteInputDTO);
        return new ResponseEntity<>(clienteRetorno, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClienteOutputDTO>> getClientes() {
        return new ResponseEntity<>(clienteService.getClientes(), HttpStatus.OK);
    }

    @GetMapping("find-by-id")
    public ResponseEntity<ClienteOutputDTO> clienteFindById(@RequestParam Integer id) {
        ClienteOutputDTO clienteOutputDTO = clienteService.findById(id);
        return new ResponseEntity<>(clienteOutputDTO, HttpStatus.OK);
    }

}