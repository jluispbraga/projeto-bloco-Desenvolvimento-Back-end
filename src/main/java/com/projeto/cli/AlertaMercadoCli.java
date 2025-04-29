package com.projeto.cli;

import com.projeto.service.AlertaMercadoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AlertaMercadoCli implements CommandLineRunner {

    private final AlertaMercadoService alertaMercadoService;

    public AlertaMercadoCli(AlertaMercadoService alertaMercadoService) {
        this.alertaMercadoService = alertaMercadoService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Alertas de Mercado ---");
        alertaMercadoService.obterTodos().forEach(System.out::println);
    }
}
