package com.example.springEmpresaXYZ.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record OrderRecordDto(
        @NotBlank String orderStatus,
        @NotBlank Date registrationDate
    ) { }
