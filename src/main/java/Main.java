import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 5);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 3, 4);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 3);
        g.addEdge(3, 5, 6);
        g.addEdge(4, 5, 2);
        g.addEdge(4, 6, 5);
        g.addEdge(5, 6, 4);
        System.out.println("original MST:");
        List<Edge> mst = g.kruskalMST();
        for (Edge e : mst) {
            System.out.println(e);
        }
        System.out.println("total weight: " + g.calculateTotalWeight(mst));
        System.out.println("\nremoving edge (1-3, weight=1)");
        Edge removed = new Edge(1, 3, 1);
        System.out.println("\ncomponents after removal:");
        List<Set<Integer>> components = g.findComponents(mst, removed);
        for (int i = 0; i < components.size(); i++) {
            System.out.println("component " + (i+1) + ": " + components.get(i));
        }
        System.out.println("\nfinding replacement edge:");
        Edge replacement = g.findReplacement(components.get(0), components.get(1), removed);
        if (replacement != null) {
            System.out.println("replacement: " + replacement);
            System.out.println("\nnew MST:");
            List<Edge> newMst = new ArrayList<>();
            for (Edge e : mst) {
                if (!e.equals(removed)) {
                    System.out.println(e);
                    newMst.add(e);
                }
            }
            System.out.println(replacement);
            newMst.add(replacement);
            System.out.println("total weight: " + g.calculateTotalWeight(newMst));
        } else {
            System.out.println("no replacement found");
        }
    }
}