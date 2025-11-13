# Minimum Spanning Tree Edge Replacement

A Java implementation that maintains tree connectivity after edge deletion using Kruskal's algorithm.

## Overview

This project solves the MST edge replacement problem: when an edge is removed from a Minimum Spanning Tree, the algorithm identifies the resulting disconnected components and finds the minimum weight edge to reconnect them.

**Key Components:**
- MST construction using Kruskal's algorithm
- Union-Find data structure with path compression
- Component detection after edge removal
- Replacement edge search

## Running the Program

### Prerequisites
- Java JDK 8 or higher

### Steps

Clone the repository:

```
git clone https://github.com/igiiaw/Bonus-Task-Kruskals-MST.git

cd Bonus-Task-Kruskals-MST/src/main/java
```

Compile all Java files:

```
javac *.java
```

Run the program:

```
java Main
```

## Implementation Approach

The algorithm uses Kruskal's method to build the initial MST by sorting edges by weight and using Union-Find to avoid cycles. When an edge is removed, the program rebuilds the Union-Find structure to identify disconnected components, then searches all edges for the minimum weight connection between components.

## Example Output

```
original MST:
(1-3, weight=1)
(0-1, weight=2)
(4-5, weight=2)
(0-2, weight=3)
(3-4, weight=3)
(5-6, weight=4)
total weight: 15

removing edge (1-3, weight=1)

components after removal:
component 1: [0, 1, 2]
component 2: [3, 4, 5, 6]

replacement: (2-3, weight=4)

new MST:
(0-1, weight=2)
(4-5, weight=2)
(0-2, weight=3)
(3-4, weight=3)
(5-6, weight=4)
(2-3, weight=4)
total weight: 18
```

The weight increases from 15 to 18 because the removed edge (weight 1) was part of the minimum spanning tree, and the cheapest alternative connection has weight 4.

## Complexity Analysis

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| MST Construction | O(E log E) | O(V + E) |
| Component Finding | O(V + E) | O(V) |
| Replacement Search | O(E) | O(1) |
| Overall | O(E log E) | O(V + E) |

## Project Structure

```
src/main/java/
├── Edge.java # Edge representation with weight comparison
├── UnionFind.java # Disjoint set for cycle detection
├── Graph.java # Main graph operations and MST logic
└── Main.java # Test program with example graph
```