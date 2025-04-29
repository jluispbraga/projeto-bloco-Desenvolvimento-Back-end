package com.projeto.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class HistoricoInvestimento {
    private Long id;
    private LocalDate dataTransacao;
    private BigDecimal valorTransacao;
}
