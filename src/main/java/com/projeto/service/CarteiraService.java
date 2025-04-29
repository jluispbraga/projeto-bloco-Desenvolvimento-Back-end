package com.projeto.service;

import com.projeto.model.Carteira;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CarteiraService {
    private static final Map<Long, Carteira> repository = new HashMap<>();

    public void incluir(Carteira carteira) {
        repository.put(carteira.getId(), carteira);
    }

    public Collection<Carteira> obterTodos() {
        return repository.values();
    }
}
