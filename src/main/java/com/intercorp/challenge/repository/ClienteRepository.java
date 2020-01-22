package com.intercorp.challenge.repository;

import com.intercorp.challenge.dto.ClienteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteDto, Long> {

    @Query(value = "SELECT AVG(TIMESTAMPDIFF(YEAR,clientes.fecha_de_nacimiento,CURDATE())) AS edad\n" +
            "     FROM clientes", nativeQuery = true)
    Float getEdadAverage();

    @Query(value = "SELECT STD(TIMESTAMPDIFF(YEAR,clientes.fecha_de_nacimiento,CURDATE())) AS edad\n" +
            "     FROM clientes", nativeQuery = true)
    Float getDesviacionEstandar();


}
