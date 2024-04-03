package main;

public class GrafoOrientado {
    public static int[][] criarIncidencia(int numeroVertices, int[][] arestas) {
        int numeroArestas = arestas.length;
        int[][] incidencia = new int[numeroVertices][numeroArestas];



        return incidencia;
    }

    public static int[][] incidenciaParaAdjacencias(int[][] incidencia) {
        int numeroVertices = incidencia.length;
        // int numeroArestas = incidencia[0].length;
        int[][] adjacencias = new int[numeroVertices][numeroVertices];


        return adjacencias;
    }
}
