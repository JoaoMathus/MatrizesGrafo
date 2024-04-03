package main;

import java.util.ArrayList;
import java.util.List;

public class GrafoNaoOrientado {
    public static int[][] criarIncidencia(int numeroVertices, int[][] arestas) {
        int numeroArestas = arestas.length;
        int[][] incidencia = new int[numeroVertices][numeroArestas];

        for (int i = 0; i < numeroArestas; i++) {
            incidencia[arestas[i][0]-1][i] += 1;
            incidencia[arestas[i][1]-1][i] += 1;
        }

        return incidencia;
    }

    public static int[][] incidenciaParaAdjacencias(int[][] incidencia) {
        int numeroArestas = incidencia[0].length;
        int numeroVertices = incidencia.length;
        int[][] adjacencias = new int[numeroVertices][numeroVertices];
        List<Integer> verticesConectados = new ArrayList<>();

        for (int i = 0; i < numeroArestas; i++) {
            for (int j = 0; j < numeroVertices; j++) {
                if (incidencia[j][i] > 0) {
                    verticesConectados.add(j);
                }
            }
            if (verticesConectados.size() == 2) {
                int v1 = verticesConectados.get(0);
                int v2 = verticesConectados.get(1);
                adjacencias[v1][v2] += 1;
                adjacencias[v2][v1] += 1;
                verticesConectados.clear();
            } else if (verticesConectados.size() == 1) {
                int v1 = verticesConectados.get(0);
                adjacencias[v1][v1] += 2;
                verticesConectados.clear();
            }
        }

        return adjacencias;
    }
}
