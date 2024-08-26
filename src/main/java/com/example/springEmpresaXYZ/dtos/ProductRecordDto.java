package com.example.springEmpresaXYZ.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRecordDto(
        @NotBlank
        @Size(min = 0, max = 250)
        String name,
        @NotNull
        BigDecimal value,
        @Size(max = 1000)
        String description,
        Boolean availability
) { }
