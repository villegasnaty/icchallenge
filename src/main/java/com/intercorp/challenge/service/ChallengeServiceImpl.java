package com.intercorp.challenge.service;

import com.intercorp.challenge.dto.ClienteDto;
import com.intercorp.challenge.mapper.ClienteMapper;
import com.intercorp.challenge.model.Cliente;
import com.intercorp.challenge.model.KpiClienteResponse;
import com.intercorp.challenge.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@Slf4j
public class ChallengeServiceImpl {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public Cliente saveCliente(Cliente cliente) {
        ClienteDto clienteDto = clienteMapper.clienteToClienteDto(cliente);
        cliente.setEdad(calculateAge(cliente));
        clienteRepository.save(clienteDto);
        return cliente;
    }

    public KpiClienteResponse calculateKpi() {
        KpiClienteResponse kpi = new KpiClienteResponse();
        kpi.setPromedioEdad(String.format("%.2f", clienteRepository.getEdadAverage()));
        kpi.setDesviacion(String.format("%.2f", clienteRepository.getDesviacionEstandar()));
        return kpi;
    }

    public List<Cliente> getClienteList() {
        List<Cliente> clientes = clienteMapper.map(clienteRepository.findAll());
        return clientes;
    }

    private Integer calculateAge(Cliente cliente) {
        try {
            LocalDate d = cliente.getFechaDeNacimiento();
            LocalDate actualDate = LocalDate.now();
            Period diff = Period.between(d, actualDate);
            return diff.getDays();
        } catch (Exception e) {
            return null;
        }

    }


}
