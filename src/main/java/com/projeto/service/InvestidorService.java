package com.projeto.service;

import com.projeto.model.Investidor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvestidorService {
    private static final Map<Long, Investidor> repository = new HashMap<>();

    public void incluir(Investidor investidor) {
        repository.put(investidor.getId(), investidor);
    }

    public Collection<Investidor> obterTodos() {
        return repository.values();
    }
}
