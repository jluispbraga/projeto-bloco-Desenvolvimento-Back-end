package com.projeto.service;

import com.projeto.model.Ativo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AtivoService {
    private static final Map<Long, Ativo> repository = new HashMap<>();

    public void incluir(Ativo ativo) {
        repository.put(ativo.getId(), ativo);
    }

    public Collection<Ativo> obterTodos() {
        return repository.values();
    }
}
