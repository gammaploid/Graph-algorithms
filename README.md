# Graph Algorithms Implementation

This project implements various graph algorithms in Java, including breadth-first search, depth-first search, and topological sort. It includes both directed and undirected graph implementations using adjacency lists.

## Features

- Graph Implementations:
  - Adjacency List Directed Graph
  - Adjacency List Undirected Graph

- Algorithms:
  - Breadth-First Search (BFS)
  - Depth-First Search (DFS)
  - Topological Sort
  - Six Degrees of Kevin Bacon implementation

## Project Structure

- `Graph.java` - Abstract base class for graph implementations
- `AdjacencyListDirectedGraph.java` - Directed graph implementation
- `AdjacencyListUndirectedGraph.java` - Undirected graph implementation
- `BreadthFirstSearch.java` - BFS algorithm implementation
- `DepthFirstSearch.java` - DFS algorithm implementation
- `TopologicalSort.java` - Topological sorting implementation
- `Vertex.java` - Vertex class implementation
- `GraphDriver.java` - Main driver class with test cases and examples

## Usage

The program accepts input commands in the format:
```
level_test additional_args
```

Where `level_test` is a number between 1 and 5:

1. Print graph (U/D for undirected/directed)
   ```
   1 U
   1 D
   ```

2. Breadth-first traversal
   ```
   2 U [startVertex]
   2 D [startVertex]
   ```

3. Depth-first traversal
   ```
   3 U [startVertex]
   3 D [startVertex]
   ```

4. Topological Sort (Y/N to print graph)
   ```
   4 Y
   4 N
   ```

5. Kevin Bacon number calculator
   ```
   5
   ```

## Example Usage

```java
// Create an undirected graph
Graph g = new AdjacencyListUndirectedGraph();

// Add edges
g.addEdge("a", "b");
g.addEdge("b", "c");
g.addEdge("b", "d");

// Perform BFS
BreadthFirstSearch bfs = new BreadthFirstSearch(g, g.getVertex("a"));
List<Vertex> traversalList = bfs.getBreadFirstTraversalList();

// Find shortest path
List<Vertex> path = bfs.pathTo(g.getVertex("d"));
```

