package com.projeto.model;

import lombok.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Ativo {
    private Long id;
    private String tipo;
    private Integer quantidade;
    private BigDecimal precoMedio;
    private List<HistoricoInvestimento> historicos = new ArrayList<>();
}
