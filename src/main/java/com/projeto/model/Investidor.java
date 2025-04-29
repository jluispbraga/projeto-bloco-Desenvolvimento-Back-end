package com.projeto.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Investidor {
    private Long id;
    private String nome;
    private List<Carteira> carteiras = new ArrayList<>();
    private List<Relatorio> relatorios = new ArrayList<>();
    private List<AlertaMercado> alertas = new ArrayList<>();
}