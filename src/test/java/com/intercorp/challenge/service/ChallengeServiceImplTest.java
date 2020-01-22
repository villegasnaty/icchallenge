package com.intercorp.challenge.service;

import com.intercorp.challenge.config.YAMLConfig;
import com.intercorp.challenge.dto.ClienteDto;
import com.intercorp.challenge.model.Cliente;
import com.intercorp.challenge.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ChallengeServiceImplTest {

    @MockBean
    private ClienteRepository clienteRepository;

    @MockBean
    private YAMLConfig yamlConfig;


    @Autowired
    private ChallengeServiceImpl challengeService;

    @Test
    void getClienteListShouldReturnSameQuantityAsRetriviedFromDatabase() {
        List<ClienteDto> mockedClientes = getMockedClienteDtos();
        when(clienteRepository.findAll()).thenReturn(mockedClientes);
        List<Cliente> clientes = challengeService.getClienteList();
        assertEquals(mockedClientes.size(), clientes.size());
    }

    @Test
    void getClienteListShouldReturnSameClientesWithFechaDeMuerte() {
        List<ClienteDto> mockedClientes = getMockedClienteDtos();
        when(clienteRepository.findAll()).thenReturn(mockedClientes);
        List<Cliente> clientes = challengeService.getClienteList();
        assertNotNull(clientes.get(0).getFechaProbableMuerte());
    }

    @Test
    void getClienteListShouldReturnCorrectFechaDeMuerte_fechaDeNacmiento_plus_esperanza() {
        List<ClienteDto> mockedClientes = getMockedClienteDtos();
        when(clienteRepository.findAll()).thenReturn(mockedClientes);
        when(yamlConfig.getEsperanza()).thenReturn(10);
        List<Cliente> clientes = challengeService.getClienteList();
        assertEquals(clientes.get(0).getFechaProbableMuerte(), mockedClientes.get(0).getFechaDeNacimiento().plusYears(10));
    }

    private List<ClienteDto> getMockedClienteDtos() {
        List<ClienteDto> mockedClientes = new ArrayList<ClienteDto>();
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setApellido("Lopez");
        clienteDto.setNombre("Pepe");
        clienteDto.setFechaDeNacimiento(LocalDate.of(2000, Month.JANUARY, 1));
        mockedClientes.add(clienteDto);
        return mockedClientes;
    }

}