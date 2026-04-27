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
}
