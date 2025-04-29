package com.projeto.loader;

import com.projeto.model.AlertaMercado;
import com.projeto.service.AlertaMercadoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class AlertaMercadoLoader implements CommandLineRunner {

    private final AlertaMercadoService alertaMercadoService;

    public AlertaMercadoLoader(AlertaMercadoService alertaMercadoService) {
        this.alertaMercadoService = alertaMercadoService;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Stream<String> linhas = Files.lines(Paths.get("alertas.txt"))) {
            linhas.forEach(linha -> {
                String[] campos = linha.split("[;,]");
                AlertaMercado alerta = new AlertaMercado();
                alerta.setId(Long.parseLong(campos[0]));
                alerta.setLimiteVariacao(new BigDecimal(campos[1]));
                alertaMercadoService.incluir(alerta);
            });
        }
        alertaMercadoService.obterTodos().forEach(System.out::println);
    }
}
