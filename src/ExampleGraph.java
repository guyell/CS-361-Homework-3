public class ExampleGraph {

    //build Graph A
    private static final int[][] EDGES_A = {
            {1,3},{1,2},{1,4},{3,5},{2,0},{4,6},
            {5,7},{0,8},{6,9},{6,11},{8,10}
    };

    public static Graph buildGraphA() {
        Graph g = new Graph(12, false);   // 12 vertices, undirected
        for (int[] e : EDGES_A) g.addEdge(e[0], e[1]);
        return g;
    }
}
