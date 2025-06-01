
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/**
 * Depth First Search (DFS) implementation for traversing a graph.
 * This class performs a depth-first traversal starting from a given source vertex.
 * It maintains the order of traversal and the visited state of each vertex.
 *
 * @author gammaploid
 */
public class DepthFirstSearch {

     List<Vertex> traversalOrder;
     Set<Vertex> visited;
     Graph graph;

    public DepthFirstSearch(Graph g, Vertex source) {
        this.graph = g;
        this.traversalOrder = new LinkedList<>();
        this.visited = new HashSet<>();
        // init graph state
        g.clearState();

        List<Vertex> vertices = g.getVertices();
        Collections.sort(vertices);

        //loop through all vertices and set them to UNVISITED to intiate graph
        for (Vertex v : vertices) {
            g.setState(v, Vertex.VertexState.UNVISITED);
         }
        dfs(source);
    }


    private void dfs(Vertex u) {
        visited.add(u);
        graph.setState(u, Vertex.VertexState.DISCOVERED);

        List<Vertex> neighbours = graph.adjacentTo(u);
        if (neighbours != null) {
            Collections.sort(neighbours); // lexicographic order
            for (Vertex v : neighbours) {
                if (graph.getState(v) == Vertex.VertexState.UNVISITED) {
                    dfs(v);
                    //prev.put(v, u);
                }
            }

        }
        graph.setState(u, Vertex.VertexState.FINISHED);
        traversalOrder.add( u);
    }


    public List<Vertex> getDepthFirstTraversalList() {
        return traversalOrder;
    }
}
