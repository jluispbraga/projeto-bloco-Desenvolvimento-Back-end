package com.projeto.loader;

import com.projeto.model.Ativo;
import com.projeto.service.AtivoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class AtivoLoader implements CommandLineRunner {

    private final AtivoService ativoService;

    public AtivoLoader(AtivoService ativoService) {
        this.ativoService = ativoService;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Stream<String> linhas = Files.lines(Paths.get("ativos.txt"))) {
            linhas.forEach(linha -> {
                String[] campos = linha.split("[;,]");
                Ativo ativo = new Ativo();
                ativo.setId(Long.parseLong(campos[0]));
                ativo.setTipo(campos[1]);
                ativo.setQuantidade(Integer.parseInt(campos[2]));
                ativo.setPrecoMedio(new BigDecimal(campos[3]));
                ativoService.incluir(ativo);
            });
        }
        ativoService.obterTodos().forEach(System.out::println);
    }
}
