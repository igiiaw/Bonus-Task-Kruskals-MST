public class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof Edge)) return false;
        Edge e = (Edge) obj;
        return (src == e.src && dest == e.dest) || (src == e.dest && dest == e.src);
    }
    public String toString() {
        return "(" + src + "-" + dest + ", weight=" + weight + ")";
    }
}