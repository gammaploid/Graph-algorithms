import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


/**
 * Topological Sort implementation for directed acyclic graphs (DAGs).
 * This class performs a topological sort on the vertices of a directed graph.
 * It uses depth-first search (DFS) to visit vertices and maintain a stack to store the sorted order.
 *
 * @author gammaploid
 */

public class TopologicalSort {

     List<Vertex> sortedList;
     Graph graph;
      Set<Vertex> visited;
     Stack<Vertex> stack;

    public TopologicalSort(Graph g) {

        this.graph = g;
        this.sortedList = new LinkedList<>();
        this.visited = new HashSet<>();
        // stack LIFO approach to store the sorted vertices and pop them in reverse order
        this.stack = new Stack<>();

        g.clearState();
        List<Vertex> vertices = g.getVertices();

        // loop through all vertices and set them to UNVISITED to intiate graph
        for (Vertex v : vertices) {
            g.setState(v, Vertex.VertexState.UNVISITED);
        }

        // Find all vertices with in-degree 0
        Map<Vertex, Integer> inDegree = new HashMap<>();

        // Initialize in-degree of all vertices to 0
        for (Vertex v : vertices) {
            inDegree.put(v, 0);
         }
// loop through all vertices and their neighbours
        for (Vertex u: vertices) {
            List<Vertex> neighbours = graph.adjacentTo(u);
            if (neighbours != null) {
                for (Vertex v : neighbours) {
                    inDegree.put(v, inDegree.get(v) + 1);
                }
            }
        }

        List<Vertex> startNodes = new ArrayList<>();
        // Collect all vertices with in-degree 0
        for (Vertex v : vertices) {
            if (inDegree.get(v) == 0) {
                startNodes.add(v);
            }

        }
        Collections.sort(startNodes); // lexographic order

        for (Vertex startNode : startNodes) {
            if (graph.getState(startNode) == Vertex.VertexState.UNVISITED) {
                 topologicalSortUtil(startNode);
            }
        }

        while (!stack.isEmpty()) {sortedList.add(stack.pop());
        }
    }

    private void topologicalSortUtil(Vertex v) {
        visited.add(v);
        graph.setState(v, Vertex.VertexState.DISCOVERED);
        // Get the neighbours of the vertex
// neighbors list is already sorted in the constructor
        List<Vertex> neighbours = graph.adjacentTo(v);

        if (neighbours != null) {
            Collections.sort(neighbours); // lexicographical order

            for (Vertex neighbour : neighbours ) {
            // check if the neighbour is unvisited
                if (graph.getState(neighbour) == Vertex.VertexState.UNVISITED) {
                    // recursively visit the neighbour
                    topologicalSortUtil(neighbour);}
            }
        }
        // After visiting all neighbours, push the vertex onto the stack
        graph.setState(v, Vertex.VertexState.FINISHED);
        stack.push(v);
    }

    public List<Vertex> getTopologicalSort() {
        return sortedList;
    }
}
