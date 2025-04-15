package org.example.vityan55.graphSample;

import java.util.List;

/**
 * Interface for implementation non-oriented graph
 */
public interface Graph {
    /**
     * Return count of edges
     * @return int count
     */
    int edgeCount();

    /**
     * Return vertex count
     * @return int count
     */
    int vertexCount();

    /**
     * Adds edge into graph
     * @param v1 First edge
     * @param v2 Second edgw
     */
    void addEdge(int v1, int v2);

    /**
     * Removes edge from graph
     * @param v1 Edge to be removed
     */
    void removeEdge(int v1, int v2);

    /**
     * Gets edges that adjacent for current edge
     * @param v1 Current edge
     * @return Iterable collection of edges
     */
    List<Integer> getAdjEdges(int v1);

    /**
     * Checks adjacent of two edges
     * @param v1 First edge
     * @param v2 Second edge
     * @return Are two edges adjacent or not
     */
    default boolean isAdj(int v1, int v2){
        for (Integer edge : getAdjEdges(v1)){
            if (edge == v2){
                return true;
            }
        }
        return false;
    }
}
