package com.projeto.loader;

import com.projeto.model.Investidor;
import com.projeto.service.InvestidorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class InvestidorLoader implements CommandLineRunner {

    private final InvestidorService investidorService;

    public InvestidorLoader(InvestidorService investidorService) {
        this.investidorService = investidorService;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Stream<String> linhas = Files.lines(Paths.get("investidores.txt"))) {
            linhas.forEach(linha -> {
                String[] campos = linha.split("[;,]");
                Investidor investidor = new Investidor();
                investidor.setId(Long.parseLong(campos[0]));
                investidor.setNome(campos[1]);
                investidorService.incluir(investidor);
            });
        }
        investidorService.obterTodos().forEach(System.out::println);
    }
}
