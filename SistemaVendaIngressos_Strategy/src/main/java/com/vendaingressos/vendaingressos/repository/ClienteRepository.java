package com.vendaingressos.vendaingressos.repository;

import com.vendaingressos.vendaingressos.entity.ClienteEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {

    private List<ClienteEntity> clienteEntities = new ArrayList<>();

    private static Integer id = 0;

    public ClienteEntity addCliente(ClienteEntity clienteEntity) {
        id++;
        clienteEntity.setIdCliente(id);
        clienteEntities.add(clienteEntity);
        return clienteEntity;
    }

    public List<ClienteEntity> getClientes() {
        return clienteEntities;
    }

    public ClienteEntity findById(Integer id) {
        ClienteEntity clienteEntityRetorno = clienteEntities.stream()
                .filter(cliente -> cliente.getIdCliente() == id)
                .findFirst().get();
        return clienteEntityRetorno;
    }

}
