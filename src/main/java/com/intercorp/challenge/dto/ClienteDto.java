package com.intercorp.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "clientes")
@Getter
@Setter
public class ClienteDto extends GenericObject {
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    //@Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate fechaDeNacimiento;
}
