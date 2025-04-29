package com.projeto.service;

import com.projeto.model.HistoricoInvestimento;
import com.projeto.model.Relatorio;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class HistoricoInvestimentoService {
    private static final Map<Long, HistoricoInvestimento> repository = new HashMap<>();

    public void incluir(HistoricoInvestimento historico) {
        repository.put(historico.getId(), historico);
    }

    public Collection<HistoricoInvestimento> obterTodos() {
        return repository.values();
    }
}
