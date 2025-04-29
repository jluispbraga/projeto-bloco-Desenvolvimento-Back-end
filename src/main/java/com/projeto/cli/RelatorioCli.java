package com.projeto.cli;

import com.projeto.service.RelatorioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RelatorioCli implements CommandLineRunner {

    private final RelatorioService relatorioService;

    public RelatorioCli(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Relatórios ---");
        relatorioService.obterTodos().forEach(System.out::println);
    }
}
