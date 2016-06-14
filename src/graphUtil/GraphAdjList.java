package graphUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that implements a directed graph.
 * <p>x
 * Created by Manu on 6/13/2016.
 */
public class GraphAdjList extends Graph {


    private Map<Integer, ArrayList<Integer>> adjListMap;

    public GraphAdjList() {
        adjListMap = new HashMap<>();
    }

    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        ArrayList<Integer> neighbors = new ArrayList<>();
        adjListMap.put(v, neighbors);
    }


    @Override
    public void implementAddEdge(int v, int w) {
        (adjListMap.get(v)).add(w);
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        return new ArrayList<Integer>(adjListMap.get(v));
    }

    @Override
    public List<Integer> getInNeighbors(int v) {
        List<Integer> inNeighbors = new ArrayList<>();
        for (int u : adjListMap.keySet()) {
            for (int w : getNeighbors(u)) {
                if (u == w) {
                    inNeighbors.add(u);
                }
            }
        }
        return inNeighbors;
    }

    @Override
    public List<Integer> getDistance2(int v) {
        if (v >= getNumVertices())
            throw new IndexOutOfBoundsException();

        List<Integer> twoHops = new ArrayList<>();
        for (int u : getNeighbors(v)) {
            twoHops.addAll(getNeighbors(u));
        }
        return twoHops;
    }

    @Override
    public String adjacencyString() {
        String s = "Adjacency list";
        s += " (size " + getNumVertices() + "+" + getNumEdges() + " integers):";
        for (int v : adjListMap.keySet()) {
            s += "\n\t" + v + ": ";
            for (int w : adjListMap.get(v))
                s += w + ", ";
        }
        return s;
    }
}
