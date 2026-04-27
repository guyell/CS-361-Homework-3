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

}
