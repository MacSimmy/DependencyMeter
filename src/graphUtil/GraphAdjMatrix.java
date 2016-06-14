package graphUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements a directed graph.
 * Created by Manu on 6/13/2016.
 */
public class GraphAdjMatrix extends Graph {

    private final int defaultNumVertices = 5;
    private int[][] adjMatrix;

    public GraphAdjMatrix() {
        adjMatrix = new int[defaultNumVertices][defaultNumVertices];
    }

    /**
     * Implement the abstract method for adding a vertex.
     * If need to increase dimensions of matrix, double them
     * to amortize cost.
     */
    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        if (v >= getNumVertices()) {
            int[][] newAdjMatrix = new int[v * 2][v * 2];
            //copy previous matrix to new one
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = newAdjMatrix;
        }
        for (int i = 0; i < adjMatrix.length; i++) {
            adjMatrix[v][i] = 0;
        }

    }

    @Override
    public void implementAddEdge(int v, int w) {
        adjMatrix[v][w] += 1;
    }

    /**
     * Implement the abstract method for finding all
     * out-neighbors of a vertex.
     * If there are multiple edges between the vertex
     * and one of its out-neighbors, this neighbor
     * appears once in the list for each of these edges.
     *
     * @param v the index of vertex.
     * @return List<Integer> a list of indices of vertices.
     */
    @Override
    public List<Integer> getNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < getNumVertices(); i++) {
            if (adjMatrix[v][i] > 0) {
                for (int j = 0; j < adjMatrix[v][i]; j++) {
                    neighbors.add(i);
                }
            }
        }
        return neighbors;
    }

    @Override
    public List<Integer> getInNeighbors(int v) {
        List<Integer> inNeighbors = new ArrayList<>();
        for (int i = 0; i < getNumVertices(); i++) {
            //this condition satisfy only if adjMatrix[i][v] > 0
            for (int j = 0; j < adjMatrix[i][v]; j++) {
                inNeighbors.add(i);
            }
        }
        return inNeighbors;
    }

    @Override
    public List<Integer> getDistance2(int v) {
        List<Integer> twoHops = new ArrayList<>();
        if (v >= getNumVertices()) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < getNumVertices(); i++) {
            if (adjMatrix[v][i] > 0) {
                for (int j = 0; j < adjMatrix[v][i]; j++) {
                    twoHops.addAll(getNeighbors(i));
                }
            }
        }
        return twoHops;
    }

    @Override
    public String adjacencyString() {
        int dim = adjMatrix.length;
        String s = "Adjacency matrix";
        s += " (size " + dim + "x" + dim + " = " + dim * dim + " integers):";
        for (int i = 0; i < dim; i++) {
            s += "\n\t" + i + ": ";
            for (int j = 0; j < adjMatrix[i].length; j++) {
                s += adjMatrix[i][j] + ", ";
            }
        }
        return s;
    }
}
