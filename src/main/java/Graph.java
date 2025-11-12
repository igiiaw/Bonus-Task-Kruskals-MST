import java.util.*;

public class Graph {
    int vertices;
    List<Edge> edges;
    Graph(int v) {
        vertices = v;
        edges = new ArrayList<>();
    }
    void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }
    List<Edge> kruskalMST() {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(vertices);
        List<Edge> result = new ArrayList<>();
        for (Edge e : edges) {
            if (uf.find(e.src) != uf.find(e.dest)) {
                uf.union(e.src, e.dest);
                result.add(e);
            }
        }
        return result;
    }
    List<Set<Integer>> findComponents(List<Edge> mst, Edge removed) {
        UnionFind uf = new UnionFind(vertices);
        for (Edge e : mst) {
            if (!e.equals(removed)) {
                uf.union(e.src, e.dest);
            }
        }
        Map<Integer, Set<Integer>> comps = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            int root = uf.find(i);
            comps.putIfAbsent(root, new HashSet<>());
            comps.get(root).add(i);
        }
        return new ArrayList<>(comps.values());
    }
    Edge findReplacement(Set<Integer> comp1, Set<Integer> comp2, Edge removed) {
        Edge minEdge = null;
        for (Edge e : edges) {
            if (e.equals(removed)) {
                continue;
            }
            boolean inComp1Src = comp1.contains(e.src);
            boolean inComp1Dest = comp1.contains(e.dest);
            if (inComp1Src != inComp1Dest) {
                if (minEdge == null || e.weight < minEdge.weight) {
                    minEdge = e;
                }
            }
        }
        return minEdge;
    }
    int calculateTotalWeight(List<Edge> mstEdges) {
        int total = 0;
        for (Edge e : mstEdges) {
            total += e.weight;
        }
        return total;
    }
}