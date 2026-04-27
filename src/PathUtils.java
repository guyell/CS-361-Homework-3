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
}
