package com.intercorp.challenge.mapper;

import com.intercorp.challenge.config.YAMLConfig;
import com.intercorp.challenge.dto.ClienteDto;
import com.intercorp.challenge.model.Cliente;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class ClienteMapper {

    @Autowired
    YAMLConfig config;

    public abstract ClienteDto clienteToClienteDto(Cliente cliente);

    @Mapping(target = "fechaProbableMuerte", expression = "java(cliente.getFechaDeNacimiento().plusYears(config.getEsperanza()))")
    abstract Cliente clienteDtoToCliente(ClienteDto clienteDto);

    public abstract @IterableMapping(qualifiedByName = "toDto")
    List<Cliente> map(List<ClienteDto> children);
}
