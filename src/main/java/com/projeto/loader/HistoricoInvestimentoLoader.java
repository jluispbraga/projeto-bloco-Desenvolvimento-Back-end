package com.projeto.loader;

import com.projeto.model.HistoricoInvestimento;
import com.projeto.service.HistoricoInvestimentoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

@Component
public class HistoricoInvestimentoLoader implements CommandLineRunner {

    private final HistoricoInvestimentoService historicoInvestimentoService;

    public HistoricoInvestimentoLoader(HistoricoInvestimentoService historicoInvestimentoService) {
        this.historicoInvestimentoService = historicoInvestimentoService;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Stream<String> linhas = Files.lines(Paths.get("historicos.txt"))) {
            linhas.forEach(linha -> {
                String[] campos = linha.split("[;,]");
                HistoricoInvestimento historico = new HistoricoInvestimento();
                historico.setId(Long.parseLong(campos[0]));
                historico.setDataTransacao(LocalDate.parse(campos[1]));
                historico.setValorTransacao(new BigDecimal(campos[2]));
                historicoInvestimentoService.incluir(historico);
            });
        }
        historicoInvestimentoService.obterTodos().forEach(System.out::println);
    }
}
