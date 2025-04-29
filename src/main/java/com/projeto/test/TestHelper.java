package com.projeto.test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Stream;

public class TestHelper {

    public static <T> void preencherMap(Object service, String arquivo) throws Exception {
        try (Stream<String> linhas = Files.lines(Paths.get(arquivo))) {
            linhas.forEach(linha -> {});
        }
    }

    public static <T> void imprimirTodos(Collection<T> colecao) {
        colecao.forEach(System.out::println);
    }
}
