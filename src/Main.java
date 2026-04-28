import java.util.List;
import java.util.function.Supplier;

public class Main{
    static void main(String[] args) {


        BFS bfs = new BFS();
        DFS dfs = new DFS();

        //for graph a
        Printer.separator("GRAPH (a)  |  Find path: 0 → 7");

        Graph graphA = ExampleGraph.buildGraphA();
        Printer.printGraph(graphA);

        //run searches (also captured inside Benchmark for timing)
        Benchmark.Result bfsA_list = Benchmark.run(() -> bfs.searchList(graphA, 0, 7));
        Benchmark.Result dfsA_list = Benchmark.run(() -> dfs.searchList(graphA, 0, 7));
        Benchmark.Result bfsA_matrix = Benchmark.run(() -> bfs.searchMatrix(graphA, 0, 7));
        Benchmark.Result dfsA_matrix = Benchmark.run(() -> dfs.searchMatrix(graphA, 0, 7));

        Printer.printPaths(graphA,
                bfsA_list.path, dfsA_list.path,
                bfsA_matrix.path, dfsA_matrix.path);

        Printer.printBenchmarks(bfsA_list, dfsA_list, bfsA_matrix, dfsA_matrix);

        //for graph b
        Printer.separator("GRAPH (b)  |  Find path: A → O");

        Graph graphB = ExampleGraph.buildGraphB();
        Printer.printGraph(graphB);

        // A = index 0,  O = index 14
        int A = graphB.getVertex("A");
        int O = graphB.getVertex("O");

        Benchmark.Result bfsB_list   = Benchmark.run(() -> bfs.searchList  (graphB, A, O));
        Benchmark.Result dfsB_list   = Benchmark.run(() -> dfs.searchList  (graphB, A, O));
        Benchmark.Result bfsB_matrix = Benchmark.run(() -> bfs.searchMatrix(graphB, A, O));
        Benchmark.Result dfsB_matrix = Benchmark.run(() -> dfs.searchMatrix(graphB, A, O));

        Printer.printPaths(graphB,
                bfsB_list.path, dfsB_list.path,
                bfsB_matrix.path, dfsB_matrix.path);

        Printer.printBenchmarks(bfsB_list, dfsB_list, bfsB_matrix, dfsB_matrix);
    }
}
