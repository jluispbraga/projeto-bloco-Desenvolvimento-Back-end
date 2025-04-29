package com.projeto.cli;

import com.projeto.service.AtivoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AtivoCli implements CommandLineRunner {

    private final AtivoService ativoService;

    public AtivoCli(AtivoService ativoService) {
        this.ativoService = ativoService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Ativos ---");
        ativoService.obterTodos().forEach(System.out::println);
    }
}
