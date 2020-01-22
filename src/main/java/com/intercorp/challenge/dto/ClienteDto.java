package com.intercorp.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity(name = "clientes")
@Getter
@Setter
public class ClienteDto extends GenericObject {
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private LocalDate fechaDeNacimiento;
}
