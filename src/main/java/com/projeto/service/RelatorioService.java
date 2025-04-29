package com.projeto.service;

import com.projeto.model.Relatorio;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RelatorioService {
    private static final Map<Long, Relatorio> repository = new HashMap<>();

    public void incluir(Relatorio relatorio) {
        repository.put(relatorio.getId(), relatorio);
    }

    public Collection<Relatorio> obterTodos() {
        return repository.values();
    }
}
