package com.projeto.service;

import com.projeto.model.AlertaMercado;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AlertaMercadoService {
    private static final Map<Long, AlertaMercado> repository = new HashMap<>();

    public void incluir(AlertaMercado alerta) {
        repository.put(alerta.getId(), alerta);
    }

    public Collection<AlertaMercado> obterTodos() {
        return repository.values();
    }
}
