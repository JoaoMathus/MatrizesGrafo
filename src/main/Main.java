package main;

public class Main {
    public static void main(String[] args) {
        int numeroVertices = 5;
        int[][] arestas = {
                {1,2},
                {1,2},
                {1,3},
                {2,5},
                {3,2},
                {3,4},
                {4,5}
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

    }
}
