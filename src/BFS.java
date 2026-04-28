import java.util.*;

public class BFS {
    public List<Integer> searchList(Graph graph, int start, int end) {
        Map<Integer, List<Integer>> adjList = graph.getAdjList();
        Map<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        parent.put(start, -1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) return PathUtils.reconstruct(parent, end);
            for (int neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        return Collections.emptyList();
    }

    public List<Integer> searchMatrix(Graph graph, int start, int end) {
        int n = graph.getNumVertices();
        int[][] matrix = graph.getAdjMatrix();

        int[] parent = new int[n];
        Arrays.fill(parent, -2);       // -2 = "not visited"
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        parent[start] = -1;            // -1 = "root, no parent"

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) return PathUtils.reconstruct(parent, end);
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (matrix[current][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }
        return Collections.emptyList();
    }
}
