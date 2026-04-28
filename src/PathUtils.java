import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PathUtils {

    public static List<Integer> reconstruct(Map<Integer, Integer> parent, int end) {
        LinkedList<Integer> path = new LinkedList<>();
        int current = end;
        while (current != -1) {
            path.addFirst(current);
            current = parent.get(current);
        }
        return path;
    }

    public static List<Integer> reconstruct(int[] parent, int end) {
        LinkedList<Integer> path = new LinkedList<>();
        int current = end;
        while (current != -1) {
            path.addFirst(current);
            current = parent[current];
        }
        return path;
    }

    public static String format(List<Integer> path, Graph graph) {
        if (path.isEmpty()) return "(no path found)";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) sb.append(" -> ");
            sb.append(graph.getLabel(path.get(i)));
        }
        return sb.toString();
    }
}