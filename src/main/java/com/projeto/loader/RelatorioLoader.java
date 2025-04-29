package com.projeto.loader;

import com.projeto.model.Relatorio;
import com.projeto.service.RelatorioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

@Component
public class RelatorioLoader implements CommandLineRunner {

    private final RelatorioService relatorioService;

    public RelatorioLoader(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Stream<String> linhas = Files.lines(Paths.get("relatorios.txt"))) {
            linhas.forEach(linha -> {
                String[] campos = linha.split("[;,]");
                Relatorio relatorio = new Relatorio();
                relatorio.setId(Long.parseLong(campos[0]));
                relatorio.setPeriodoInicio(LocalDate.parse(campos[1]));
                relatorio.setPeriodoFim(LocalDate.parse(campos[2]));
                relatorio.setTotalInvestido(new BigDecimal(campos[3]));
                relatorioService.incluir(relatorio);
            });
        }
        relatorioService.obterTodos().forEach(System.out::println);
    }
}
