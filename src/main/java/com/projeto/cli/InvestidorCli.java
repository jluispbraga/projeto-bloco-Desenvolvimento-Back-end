package com.projeto.cli;

import com.projeto.service.InvestidorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InvestidorCli implements CommandLineRunner {

    private final InvestidorService investidorService;

    public InvestidorCli(InvestidorService investidorService) {
        this.investidorService = investidorService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Investidores ---");
        investidorService.obterTodos().forEach(System.out::println);
    }
}
