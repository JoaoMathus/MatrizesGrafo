package main;

public class Main {
    public static void main(String[] args) {
        // Não orientado
        int numeroVertices = 5;
        int[][] arestas = {
                {1,1},
                {1,2},
                {1,2},
                {1,3},
                {2,5},
                {3,2},
                {3,4},
                {4,5}
        };

        // Orientado
        int verticesOrientados = 5;
        int[][] setas = {
                {1,3},
                {1,4},
                {2,1},
                {2,2},
                {3,5},
                {5,2},
                {5,3}
        };

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
    }
}
