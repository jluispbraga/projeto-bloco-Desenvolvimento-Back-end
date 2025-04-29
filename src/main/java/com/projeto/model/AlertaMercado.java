package com.projeto.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class AlertaMercado {
    private Long id;
    private BigDecimal limiteVariacao;
}
