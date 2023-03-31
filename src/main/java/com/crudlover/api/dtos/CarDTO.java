package com.crudlover.api.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

public record CarDTO(

    @NotBlank
    String modelo,

    @NotBlank
    String fabricante,

    @Past
    Date dataFabricacao,

    @Positive
    int valor,

    @Positive
    int anoModelo
) {}