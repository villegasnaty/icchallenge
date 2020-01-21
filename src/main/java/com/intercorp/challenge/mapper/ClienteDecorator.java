package com.intercorp.challenge.mapper;

import com.intercorp.challenge.dto.ClienteDto;
import com.intercorp.challenge.model.Cliente;

public abstract class ClienteDecorator implements ClienteMapper {

    private ClienteMapper delegate;

    public ClienteDecorator(ClienteMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public Cliente clienteDtoToCliente(ClienteDto clienteDto, Integer esperanza) {

        Cliente cliente = delegate.clienteDtoToCliente(clienteDto, esperanza);
        cliente.setFechaProbableMuerte(cliente.getFechaDeNacimiento().plusYears(esperanza));
        return cliente;
    }

}
