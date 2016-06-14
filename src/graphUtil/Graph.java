package graphUtil;

import java.util.*;

/**
 * Created by Manu on 6/13/2016.
 */
public abstract class Graph {

    private int numVertices;
    private int numEdges;
    //optional for labels.
    private Map<Integer, String> vertexLabels;

    public Graph() {
        numEdges = 0;
        numVertices = 0;
        vertexLabels = null;
    }

    /**
     * total number of vertex
     *
     * @return numVertices
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * return total no of edges
     *
     * @return numEdges
     */
    public int getNumEdges() {
        return numEdges;
    }

    /**
     * method to add simple int vertex to graph
     *
     * @return index of newly added vertex
     */
    public int addVertex() {
        implementAddVertex();
        numVertices++;
        return (numVertices - 1);
    }

    /**
     * Abstract method implementing adding a new vertex to the representation of
     * the graph.
     */
    public abstract void implementAddVertex();

    /**
     * Abstract method implementing new edges
     *
     * @param v
     * @param w
     */
    public abstract void implementAddEdge(int v, int w);

    /**
     * Add edge between two vertex v and w
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        numEdges++;
        if (v < numVertices && w < numVertices) {
            implementAddEdge(v, w);
        } else {
            throw new IndexOutOfBoundsException("vertex out of bound exception");
        }
    }

    /**
     * Method will return all neighbors of vertex v
     *
     * @param v Index of vertex in question.
     * @return List of indices of all vertices that are adjacent to v via
     * incoming edges to v.
     */
    public abstract List<Integer> getNeighbors(int v);

    /**
     * @param v
     * @return
     */
    public abstract List<Integer> getInNeighbors(int v);

    /**
     * The degree sequence of a graph is a sorted (organized in numerical order
     * from largest to smallest, possibly with repetitions) list of the degrees
     * of the vertices in the graph.
     *
     * @return List<Integer></>
     */
    private List<Integer> degreeSequence() {
        List<Integer> degreeSequence = new ArrayList<>();

        for (int i = 0; i < getNumVertices(); i++) {
            degreeSequence.add((getNeighbors(i).size() + getInNeighbors(i).size()));
        }
        degreeSequence.sort((o1, o2) -> o2.compareTo(o1));
        return degreeSequence;
    }

    /**
     * Get all the vertices that are 2 away from the vertex in question.
     *
     * @param v
     * @return a list of vertices which are at distance 2 from the given node
     */
    public abstract List<Integer> getDistance2(int v);

    /**
     * Return a String representation of the graph
     *
     * @return A string representation of the graph
     */
    public String toString() {
        String s = "\nGraph with " + numVertices + " vertices and " + numEdges + " edges.\n";
        s += "Degree sequence: " + degreeSequence() + ".\n";
        if (numVertices <= 20)
            s += adjacencyString();
        return s;
    }

    /**
     * Generate string representation of adjacency list
     *
     * @return the String
     */
    public abstract String adjacencyString();


    /**
     * Initialize the labels Map
     */
    public void initializeLabels() {
        vertexLabels = new HashMap<>();
    }


    public boolean hasVertex(int v) {
        return v < getNumVertices();
    }

    public boolean hasVertex(String label) {
        return vertexLabels.containsValue(label);
    }

    public void addLabel(int v, String label) {
        if (v < getNumVertices() && !vertexLabels.containsKey(v)) {
            vertexLabels.put(v, label);
        } else {
            System.out.println("ERROR: tried to label a vertex that is out of range or already " +
                    "labeled");
        }
    }


    public String getLabel(int v) {
        if (vertexLabels.containsKey(v)) {
            return vertexLabels.get(v);
        } else {
            return null;
        }
    }

    public int getIndex(String label) {
        for (Map.Entry<Integer, String> entry :
                vertexLabels.entrySet()) {
            if (entry.getValue().equals(label)) {
                return entry.getKey();
            }
        }
        System.out.println("ERROR: No vertex with this label");
        return -1;
    }
}
