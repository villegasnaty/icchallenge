package com.intercorp.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Cliente {
    @NotEmpty(message = "Nombre no puede estar vacío")
    private String nombre;
    @NotEmpty(message = "Apellido no puede estar vacío")
    private String apellido;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer edad;
    @NotNull(message = "fecha de nacimiento no puede estar vacío")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-3")
    private LocalDate fechaDeNacimiento;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-3")
    private LocalDate fechaProbableMuerte;
}
