import java.util.*;

public class DFS {

    public List<Integer> searchList(Graph graph, int start, int end) {
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        parent.put(start, -1);
        boolean found = dfsListHelper(graph.getAdjList(), start, end, visited, parent);
        return found ? PathUtils.reconstruct(parent, end) : Collections.emptyList();
    }

    private boolean dfsListHelper(Map<Integer, List<Integer>> adjList,
                                  int current, int end,
                                  Set<Integer> visited,
                                  Map<Integer, Integer> parent) {
        visited.add(current);
        if (current == end) return true;
        for (int neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                parent.put(neighbor, current);
                if (dfsListHelper(adjList, neighbor, end, visited, parent)) return true;
            }
        }
        return false;
    }

    public List<Integer> searchMatrix(Graph graph, int start, int end) {
        int n = graph.getNumVertices();
        int[] parent = new int[n];
        Arrays.fill(parent, -2);       // -2 = "not visited"
        boolean[] visited = new boolean[n];
        parent[start] = -1;
        boolean found = dfsMatrixHelper(graph.getAdjMatrix(), start, end, n, visited, parent);
        return found ? PathUtils.reconstruct(parent, end) : Collections.emptyList();
    }

    private boolean dfsMatrixHelper(int[][] matrix,
                                    int current, int end, int n,
                                    boolean[] visited, int[] parent) {
        visited[current] = true;
        if (current == end) return true;
        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (matrix[current][neighbor] == 1 && !visited[neighbor]) {
                parent[neighbor] = current;
                if (dfsMatrixHelper(matrix, neighbor, end, n, visited, parent)) return true;
            }
        }
        return false;
    }
}