import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final int numVertices;
    private final boolean directed;
    private final Map<Integer, List<Integer>> adjList;
    private final int[][] adjMatrix;

    private final String[] labels;

    public Graph(int numVertices, boolean directed, String[] labels) {
        this.numVertices = numVertices;
        this.directed = directed;
        this.labels = labels;
        this.adjList = new LinkedHashMap<>();
        this.adjMatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) adjList.put(i, new ArrayList<>());
    }

    private static String[] defaultLabels(int n) {
        String[] l = new String[n];
        for (int i = 0; i < n; i++) l[i] = String.valueOf(i);
        return l;
    }

    public Graph(int numVertices, boolean directed) {
        this(numVertices, directed, defaultLabels(numVertices));
    }

    public void addEdge(int from, int to) {
        adjList.get(from).add(to);
        adjMatrix[from][to] = 1;
        if (!directed) {
            adjList.get(to).add(from);
            adjMatrix[to][from] = 1;
        }
    }

    //getters
    public int getNumVertices() {
        return numVertices;
    }

    public Map<Integer, List<Integer>> getAdjList() {
        return adjList;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public String getLabel(int vertex) {
        return labels[vertex];
    }

    public String[] getLabels() {
        return labels;
    }

    public int getVertex(String label) {
        for (int i = 0; i < labels.length; i++)
            if (labels[i].equals(label)) return i;
        throw new IllegalArgumentException("Label not found: " + label);
    }

    //print methods for the graph
    public void printAdjList() {
        System.out.println("Adjacency List:");
        for (Map.Entry<Integer, List<Integer>> e : adjList.entrySet()) {
            System.out.print(" " + labels[e.getKey()] + " -> ");
            List<Integer> neighbors = e.getValue();
            for (int i = 0; i < neighbors.size(); i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(labels[neighbors.get(i)]);
            }
            System.out.println();
        }
    }

    public void printAdjMatrix() {
        System.out.println("Adjacency Matrix:");
        for (String l : labels) System.out.printf("%3s", l);
        System.out.println();
        for (int i = 0; i < numVertices; i++) {
            System.out.printf("  %3s  ", labels[i]);
            for (int v : adjMatrix[i]) System.out.printf("%3d", v);
            System.out.println();
        }
    }
}
