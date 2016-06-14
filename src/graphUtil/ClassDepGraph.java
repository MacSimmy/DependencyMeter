package graphUtil;

import nodes.ClassObject;

import java.util.Set;

/**
 * A class which represents a graph of all classes in project
 * Nodes in the graph are all java files including classes and interfaces
 * Created by Manu on  6/14/2016.
 */
public class ClassDepGraph {

    public ClassDepGraph() {

    }

    public int getNumVertices() {
        return 0;
    }

    public Set<ClassObject> getVertices() {
        return null;
    }

    /**
     * Get the number of road segments in the graph
     *
     * @return The number of edges in the graph.
     */
    public int getNumEdges() {
        return 0;
    }

    /**
     * Add a vertex of ClassObject object
     *
     * @param location
     * @return
     */
    public boolean addVertex(ClassObject location) {
        return false;
    }


    public void addEdge(ClassObject from, ClassObject to) throws IllegalArgumentException {

    }
}
