import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;



/**
 * Adjacency List implementation of an undirected graph.
 * This class uses a map to maintain vertices and another map to maintain the adjacency list.
 * It supports adding vertices, adding edges, checking for edges, and retrieving adjacent vertices.
 * @author gammaploid
 */

public class AdjacencyListUndirectedGraph extends Graph {

    private Map<String, Vertex> vertices;
    private Map<Vertex, Set<Vertex>> adj;

    // Alternative adjacency list representations:
    // private Map<Vertex, List<Vertex>> adjList; // Using  list
    // private Map<Vertex, Vertex[]> adjArray; // Using array
    public AdjacencyListUndirectedGraph() {
        // tree map for vertexes
        this.vertices = new TreeMap<>();
        // tree map for adjacency list
        this.adj = new TreeMap<>();
    }

    @Override
    void addVertex(Vertex v) {
        if (!vertices.containsKey(v.getLabel())) {
            vertices.put(v.getLabel(), v);
            adj.put(v, new TreeSet<>());


            // if (adjList != null) adjList.put(v, new ArrayList<>());
            // if (adjArray != null) // requires knowing max degree or resising
        }
    }

    @Override
    void addEdge(Vertex v, Vertex w) {
        addVertex(v); // Ensure v exists
        addVertex(w); // Ensure w exists
        // For undirected graph, add edge in both directions
        adj.get(v).add(w);
        adj.get(w).add(v);




        // if (adjList != null) {
        //    adjList.get(v).add(w);
        //    adjList.get(w).add(v);}
        // if (adjArray != null) { adjArray.get(v)[adjArray.get(v).length] = w;
        //    adjArray.get(w)[adjArray.get(w).length] = v;
        //       }


        // v.setOutDegree(v.getOutDegree() +1); // or just degree for undirected
        // v.setInDegree(v.getInDegree() +1);
        // w.setOutDegree(w.getOutDegree() + 1);
        // w.setInDegree(w.getInDegree() + 1);
    }

    @Override
    List<Vertex> adjacentTo(Vertex v) {
        if (!hasVertex(v) || adj.get(v) == null ||adj.get(v).isEmpty()) {

            // if (adjList != null && (!hasVertex(v) || adjList.get(v) == null || adjList.get(v).isEmpty())) return null;
            // if (adjArray != null && (!hasVertex(v) || adjArray.get(v) == null || adjArray.get(v).isEmpty()) )  return null;

            return null;
        }
        return new ArrayList<>(adj.get(v));

        // if (adjList != null) return new ArrayList<>(adjList.get(v));
        // if (adjArray != null) return Arrays.asList(adjArray.get(v));
        // return null;

    }



    @Override
    int degree( Vertex v) {

        // if (adjList != null && (!hasVertex(v) || adjList.get(v) == null)) return 0;
// if (adjArray != null &&(!hasVertex(v) || adjArray.get(v) == null) ) return 0;

        if (!hasVertex(v) || adj.get(v) == null ) {
            return 0;
        }
        return adj.get(v).size(); //for directed graph out of degree


        // if (adjList != null) return adjList.get(v).size();
        // if (adjArray != null && adjArray.get(v) != null)   return adjArray.get(v).length;
        // return 0;


    }

    @Override
    List<Vertex> getVertices() {
        List<Vertex> vertexList = new ArrayList<>(vertices.values());

        Collections.sort(vertexList); //  lexico ordered list
        return vertexList;
    }

    @Override
    boolean hasEdge(Vertex v, Vertex w) {
        return hasVertex(v) && hasVertex(w) && adj.get(v) != null && adj.get(v).contains(w);
    }

    @Override
    boolean hasVertex(Vertex vertex) {
        return vertices.containsKey(vertex.getLabel());
    }

    @Override
    Vertex getVertex(String vLabel) {
        return vertices.get(vLabel);
    }
}
