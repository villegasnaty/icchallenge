package com.intercorp.challenge.controller;

import com.intercorp.challenge.model.Cliente;
import com.intercorp.challenge.model.KpiClienteResponse;
import com.intercorp.challenge.service.ChallengeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@Slf4j
public class ClienteController {

    @Autowired
    private ChallengeServiceImpl challengeService;

    @RequestMapping(value = "/creacliente", method = RequestMethod.POST)
    public ResponseEntity<Cliente> creaCliente(@Valid @RequestBody Cliente cliente) throws ParseException {
        cliente = challengeService.saveCliente(cliente);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/kpideclientes", method = RequestMethod.GET)
    public ResponseEntity<KpiClienteResponse> getTotalPlayers() {
        KpiClienteResponse kpi = challengeService.calculateKpi();
        return new ResponseEntity<KpiClienteResponse>(kpi, HttpStatus.OK);
    }

    @RequestMapping(value = "/listclientes", method = RequestMethod.GET)
    //public ResponseEntity<List<Cliente>> getClienteList() {
     //   List<Cliente> clientes = challengeService.getClienteList();
      //  return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    //}

    public ResponseEntity<Cliente> getClienteList() {
        Cliente clientes = challengeService.getClienteList();
        return new ResponseEntity<Cliente>(clientes, HttpStatus.OK);
    }

}
