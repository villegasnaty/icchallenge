package com.intercorp.challenge.mapper;

import com.intercorp.challenge.config.YAMLConfig;
import com.intercorp.challenge.dto.ClienteDto;
import com.intercorp.challenge.model.Cliente;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@DecoratedWith(ClienteDecorator.class)
@Mapper(uses = YAMLConfig.class)
public interface ClienteMapper {


    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDto clienteToClienteDto(Cliente cliente);

    Cliente clienteDtoToCliente(ClienteDto clienteDto, Integer esperanza);

    @IterableMapping(qualifiedByName = "toDto") // won't work without it
    List<Cliente> map(List<ClienteDto> children);
}
