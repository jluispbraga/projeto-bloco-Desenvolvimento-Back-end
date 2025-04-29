package com.projeto.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Carteira {
    private Long id;
    private String nomeCarteira;
    private List<Ativo> ativos = new ArrayList<>();
}
