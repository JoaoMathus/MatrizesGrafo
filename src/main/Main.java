package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Não orientado
        int numeroVertices = 5;
        List<Integer[]> arestas = new ArrayList<>();

        arestas.add(new Integer[]{1,2});
        arestas.add(new Integer[]{1,3});
        arestas.add(new Integer[]{2,5});
        arestas.add(new Integer[]{3,2});
        arestas.add(new Integer[]{3,4});
        arestas.add(new Integer[]{4,5});


        // Orientado
        int verticesOrientados = 5;
        List<Integer[]> setas = new ArrayList<>();

        setas.add(new Integer[]{1,3});
        setas.add(new Integer[]{1,4});
        setas.add(new Integer[]{2,1});
        setas.add(new Integer[]{2,2});
        setas.add(new Integer[]{3,5});
        setas.add(new Integer[]{5,2});
        setas.add(new Integer[]{5,3});

        System.out.println(":: Grafos não orientados ::\n");

        System.out.println("Matriz de incidência:");
        java.util.Arrays.stream(GrafoNaoOrientado.criarIncidencia(numeroVertices, arestas))
                .forEach(linha -> System.out.println(java.util.Arrays.toString(linha)));

        System.out.println();

        System.out.println("Matriz de adjacências:");
        java.util.Arrays.stream(
                        GrafoNaoOrientado.incidenciaParaAdjacencias(
                                GrafoNaoOrientado.criarIncidencia(numeroVertices, arestas)
                        )
                )
                .forEach(linha -> System.out.println(java.util.Arrays.toString(linha)));

        System.out.println();
        System.out.println();

        System.out.println(":: Grafo orientado ::");

        System.out.println("Matriz de incidência:");
        java.util.Arrays.stream(GrafoOrientado.criarIncidencia(verticesOrientados, setas))
                .forEach(linha -> System.out.println(java.util.Arrays.toString(linha)));

        System.out.println("Matriz de adjacências:");
        java.util.Arrays.stream(GrafoOrientado.incidenciaParaAdjacencias(
                GrafoOrientado.criarIncidencia(verticesOrientados, setas)
        )).forEach(linha -> System.out.println(java.util.Arrays.toString(linha)));

        Entrada entrada = new Entrada();

        entrada.coletarDados();
        entrada.imprimirTudo();
    }
}
