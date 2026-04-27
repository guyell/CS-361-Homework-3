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

    //build graph b
    private static final String[] LABELS_B =
            {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};

    private static final int[][] EDGES_B = {
            {0,1},{0,2},           // A->B, A->C
            {1,3},                 // B->D
            {2,3},                 // C->D
            {3,4},                 // D->E
            {4,5},{4,6},           // E->F, E->G
            {5,7},{5,3},           // F->H, F->D
            {6,13},{6,10},{6,7},   // G->N, G->K, G->H
            {7,8},                 // H->I
            {8,14},{8,9},          // I->O, I->J
            {9,3},                 // J->D
            {10,11},               // K->L
            {11,14},{11,6},        // L->O, L->G
            {12,14},{12,6},        // M->O, M->G
            {13,14},{13,11}        // N->O, N->L
    };

    public static Graph buildGraphB() {
        Graph g = new Graph(15, true, LABELS_B);  // 15 vertices, directed
        for (int[] e : EDGES_B) g.addEdge(e[0], e[1]);
        return g;
    }
}
