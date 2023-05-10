package com.vendaingressos.vendaingressos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vendaingressos.vendaingressos.dto.cliente.ClienteInputDTO;
import com.vendaingressos.vendaingressos.dto.cliente.ClienteOutputDTO;
import com.vendaingressos.vendaingressos.entity.ClienteEntity;
import com.vendaingressos.vendaingressos.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final ObjectMapper objectMapper;

    public ClienteOutputDTO create(ClienteInputDTO clienteInputDTO) {

        ClienteEntity clienteEntity = objectMapper.convertValue(clienteInputDTO, ClienteEntity.class);
        ClienteEntity clienteEntityRetorno = clienteRepository.addCliente(clienteEntity);

        ClienteOutputDTO clienteDTORetorno = objectMapper.convertValue(clienteEntityRetorno, ClienteOutputDTO.class);
        return clienteDTORetorno;
    }

    public List<ClienteOutputDTO> getClientes() {
        List<ClienteOutputDTO> clientes = clienteRepository.getClientes().stream()
                .map(cliente -> {
                    ClienteOutputDTO clienteOutputDTO = objectMapper.convertValue(cliente, ClienteOutputDTO.class);
                    return clienteOutputDTO;
                }).collect(Collectors.toList());

        return clientes;
    }

    public ClienteOutputDTO findById(Integer id) {
        ClienteEntity clienteEntity = clienteRepository.findById(id);
        ClienteOutputDTO clienteOutputDTO = objectMapper.convertValue(clienteEntity, ClienteOutputDTO.class);
        return clienteOutputDTO;
    }
}
