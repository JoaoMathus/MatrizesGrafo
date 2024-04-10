package main;

import java.util.ArrayList;
import java.util.List;

public class GrafoOrientado {
    public static int[][] criarIncidencia(int numeroVertices, List<Integer[]> arestas) {
        int numeroArestas = arestas.size();
        int[][] incidencia = new int[numeroVertices][numeroArestas];


        for (int i = 0; i < numeroArestas; i++) {
            int v1 = arestas.get(i)[0];
            int v2 = arestas.get(i)[1];
            if (v1 == v2) {
                incidencia[v1-1][i] += 1;
            } else {
                incidencia[v1-1][i] += 1;
                incidencia[v2-1][i] -= 1;
            }
        }

        return incidencia;
    }

    public static int[][] incidenciaParaAdjacencias(int[][] incidencia) {
        int numeroVertices = incidencia.length;
        int numeroArestas = incidencia[0].length;
        int[][] adjacencias = new int[numeroVertices][numeroVertices];
        List<Integer> verticesConectados = new ArrayList<>();

        for (int i = 0; i < numeroArestas; i++) {
            for (int j = 0; j < numeroVertices; j++) {
                if (incidencia[j][i] != 0) {
                    verticesConectados.add(j);
                }
            }
            if (verticesConectados.size() == 2) {
                int v1 = verticesConectados.get(0);
                int v2 = verticesConectados.get(1);
                if (incidencia[v1][i] > 0) {
                    adjacencias[v1][v2] += 1;
                } else {
                    adjacencias[v2][v1] += 1;
                }
                verticesConectados.clear();
            } else if (verticesConectados.size() == 1) {
                int v1 = verticesConectados.get(0);
                adjacencias[v1][v1] += 1;
                verticesConectados.clear();
            }
        }

        return adjacencias;
    }
}
