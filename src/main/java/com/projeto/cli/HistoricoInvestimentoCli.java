package com.projeto.cli;

import com.projeto.service.HistoricoInvestimentoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HistoricoInvestimentoCli implements CommandLineRunner {

    private final HistoricoInvestimentoService historicoInvestimentoService;

    public HistoricoInvestimentoCli(HistoricoInvestimentoService historicoInvestimentoService) {
        this.historicoInvestimentoService = historicoInvestimentoService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Histórico de Investimentos ---");
        historicoInvestimentoService.obterTodos().forEach(System.out::println);
    }
}
