package com.projeto.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Relatorio {
    private Long id;
    private LocalDate periodoInicio;
    private LocalDate periodoFim;
    private BigDecimal totalInvestido;
}
