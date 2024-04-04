package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entrada {
    private Scanner input;
    private boolean orientado;
    private int numeroVertices;
    private List<Integer[]> arestas;

    public Entrada() {
        input = new Scanner(System.in);
        orientado = false;
        numeroVertices = 0;
        arestas = new ArrayList<>();
    }

    public void coletarDados() {
        String resposta;

        do {
            System.out.println("Grafo orientado? (s/n)");
            resposta = input.next();
            input.nextLine();
        } while (
                (!resposta.equalsIgnoreCase("s")) && (!resposta.equalsIgnoreCase("n"))
        );

        orientado = resposta.equalsIgnoreCase("s");

        System.out.println("Digite o número de vértices:");
        setNumeroVertices(input.nextInt());
        input.nextLine();

        String todosVertices;
        System.out.println("Digite as setas (a,b <espaço> c,d <espaço>... :");
        todosVertices = input.nextLine();
        input.close();

        var listaVertices = todosVertices.split(" ");
        List<Integer[]> arestas = new ArrayList<>();
        for (var pares : listaVertices) {
            String[] par = pares.split(",");
            arestas.add( new Integer[]{ Integer.parseInt(par[0]), Integer.parseInt(par[1]) });
        }

        setArestas(arestas);
    }

    public void imprimirTudo() {
        System.out.println("Número de vértices: " + getNumeroVertices());
        System.out.println("Conjunto de arestas:");
        getArestas().forEach(par -> System.out.println(java.util.Arrays.toString(par)));
        System.out.println();

        System.out.println("Matriz de incidência:");
        java.util.Arrays.stream(criarMatrizIncidencia(getNumeroVertices(), getArestas()))
                        .forEach(linha ->
                                System.out.println(java.util.Arrays.toString(linha)));

        System.out.println("Matriz de adjacências:");
        java.util.Arrays.stream(criarMatrizAdjacencias())
                        .forEach(linha ->
                                System.out.println(java.util.Arrays.toString(linha)));
    }

    private int[][] criarMatrizIncidencia(int numeroVertices, List<Integer[]> arestas) {
        if (orientado) {
            return GrafoOrientado.criarIncidencia(numeroVertices, arestas);
        }
        return GrafoNaoOrientado.criarIncidencia(numeroVertices, arestas);
    }

    private int[][] criarMatrizAdjacencias() {
        if (orientado) {
            return GrafoOrientado.incidenciaParaAdjacencias(
                    criarMatrizIncidencia(getNumeroVertices(), getArestas())
            );
        }
        return GrafoNaoOrientado.incidenciaParaAdjacencias(
                criarMatrizIncidencia(getNumeroVertices(), getArestas())
        );
    }

    public int getNumeroVertices() {
        return numeroVertices;
    }

    public void setNumeroVertices(int numeroVertices) {
        this.numeroVertices = numeroVertices;
    }

    public List<Integer[]> getArestas() {
        return arestas;
    }

    public void setArestas(List<Integer[]> arestas) {
        this.arestas = arestas;
    }
}
