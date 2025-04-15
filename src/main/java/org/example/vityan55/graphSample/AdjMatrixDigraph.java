package org.example.vityan55.graphSample;

/**
 * A directed graph based on an adjacency matrix
 */
public class AdjMatrixDigraph extends AdjMatrixGraph implements Digraph {
    /**
     * Constructor with vertexes count
     * @param vertexCount Count of vertexes
     */
    public AdjMatrixDigraph(int vertexCount) {
        super(vertexCount);
    }
}
