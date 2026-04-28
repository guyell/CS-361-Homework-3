import java.util.List;

public class Printer{
    //header
    public static void separator(String title) {
        System.out.println("\n" + "═".repeat(65));
        System.out.println("  " + title);
        System.out.println("═".repeat(65));
    }

    public static void section(String title) {
        int pad = Math.max(0, 60 - title.length());
        System.out.println("\n " + title + " " + "─".repeat(pad));
    }

    //graphs
    public static void printGraph(Graph graph) {
        section("Adjacency List");
        graph.printAdjList();
        section("Adjacency Matrix");
        graph.printAdjMatrix();
    }

    public static void printPaths(Graph graph,
                                  List<Integer> bfsList,
                                  List<Integer> dfsList,
                                  List<Integer> bfsMatrix,
                                  List<Integer> dfsMatrix) {
        section("Paths found");
        System.out.printf(" %-22s : %s  [%d nodes]%n",
                "BFS (adj-list)",   PathUtils.format(bfsList,   graph), bfsList.size());
        System.out.printf("  %-22s : %s  [%d nodes]%n",
                "DFS (adj-list)",   PathUtils.format(dfsList,   graph), dfsList.size());
        System.out.printf("  %-22s : %s  [%d nodes]%n",
                "BFS (adj-matrix)", PathUtils.format(bfsMatrix, graph), bfsMatrix.size());
        System.out.printf("  %-22s : %s  [%d nodes]%n",
                "DFS (adj-matrix)", PathUtils.format(dfsMatrix, graph), dfsMatrix.size());
    }
    public static void printBenchmarks(Benchmark.Result bfsList,
                                       Benchmark.Result dfsList,
                                       Benchmark.Result bfsMatrix,
                                       Benchmark.Result dfsMatrix) {
        section(String.format("Performance (avg over %d runs)", Benchmark.RUNS));
        System.out.printf("  %-22s  Time: %7d ns   Memory: %6d bytes%n",
                "BFS (adj-list)",   bfsList.avgTimeNs,   bfsList.avgMemBytes);
        System.out.printf("  %-22s  Time: %7d ns   Memory: %6d bytes%n",
                "DFS (adj-list)",   dfsList.avgTimeNs,   dfsList.avgMemBytes);
        System.out.printf("  %-22s  Time: %7d ns   Memory: %6d bytes%n",
                "BFS (adj-matrix)", bfsMatrix.avgTimeNs, bfsMatrix.avgMemBytes);
        System.out.printf("  %-22s  Time: %7d ns   Memory: %6d bytes%n",
                "DFS (adj-matrix)", dfsMatrix.avgTimeNs, dfsMatrix.avgMemBytes);
    }

}
