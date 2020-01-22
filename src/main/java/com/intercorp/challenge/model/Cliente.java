package com.intercorp.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ApiModel("Model Cliente")
public class Cliente {
    @NotEmpty(message = "Nombre no puede estar vacío")
    @ApiModelProperty(value = "Nombre del cliente", required = true)
    private String nombre;
    @NotEmpty(message = "Apellido no puede estar vacío")
    @ApiModelProperty(value = "Apellido del cliente", required = true)
    private String apellido;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer edad;
    @ApiModelProperty(value = "Fecha de nacimiento del cliente", required = true)
    @NotNull(message = "fecha de nacimiento no puede estar vacío")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-3")
    private LocalDate fechaDeNacimiento;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-3")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate fechaProbableMuerte;

}
