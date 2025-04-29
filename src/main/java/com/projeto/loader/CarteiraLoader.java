package com.projeto.loader;

import com.projeto.model.Carteira;
import com.projeto.service.CarteiraService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class CarteiraLoader implements CommandLineRunner {

    private final CarteiraService carteiraService;

    public CarteiraLoader(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Stream<String> linhas = Files.lines(Paths.get("carteiras.txt"))) {
            linhas.forEach(linha -> {
                String[] campos = linha.split("[;,]");
                Carteira carteira = new Carteira();
                carteira.setId(Long.parseLong(campos[0]));
                carteira.setNomeCarteira(campos[1]);
                carteiraService.incluir(carteira);
            });
        }
        carteiraService.obterTodos().forEach(System.out::println);
    }
}
