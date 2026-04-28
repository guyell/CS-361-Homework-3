public class Print {
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

}
