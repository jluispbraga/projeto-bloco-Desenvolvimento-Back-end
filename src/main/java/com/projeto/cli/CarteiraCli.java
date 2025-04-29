package com.projeto.cli;

import com.projeto.service.CarteiraService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarteiraCli implements CommandLineRunner {

    private final CarteiraService carteiraService;

    public CarteiraCli(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Carteiras ---");
        carteiraService.obterTodos().forEach(System.out::println);
    }
}
