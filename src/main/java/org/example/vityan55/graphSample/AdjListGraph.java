package org.example.vityan55.graphSample;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A graph based on an adjacency list
 */
public class AdjListGraph implements Graph {
    private final List<List<Integer>> adjList = new ArrayList<>();
    private int edgeCount;

    @Override
    public int edgeCount() {
        return edgeCount;
    }

    @Override
    public int vertexCount() {
        return adjList.size();
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0){
            throw new IllegalArgumentException("Index must be non-negative");
        }

        int maxVertex = Math.max(v1, v2);

        while (adjList.size() <= maxVertex) {
            adjList.add(new ArrayList<>());
        }

        if (!isAdj(v1, v2)) {
            adjList.get(v1).add(v2);

            if (!(this instanceof Digraph)) {
                adjList.get(v2).add(v1);
            }

            edgeCount++;
        }
    }

    @Override
    public void removeEdge(int v1, int v2) {
        if (isInvalidIndex(v1) || isInvalidIndex(v2)) {
            throw new IllegalArgumentException("Wrong index of removable edge");
        }

        if (adjList.get(v1).contains(v2)) {
            adjList.get(v1).remove(Integer.valueOf(v2));
            if (!(this instanceof Digraph)) {
                adjList.get(v2).remove(Integer.valueOf(v1));
            }
            edgeCount--;
        } else throw new NoSuchElementException("Edge " + v1 + " -> " + v2 + " does not exists");
    }

    @Override
    public List<Integer> getAdjEdges(int v1) {
        if (isInvalidIndex(v1)){
            throw new IllegalArgumentException("Wrong index " + v1 + " of edge with adjacent edges");
        }
        return new ArrayList<>(adjList.get(v1));
    }

    /**
     *
     * @param v1 Vertex to check
     * @return Is index invalid
     */
    private boolean isInvalidIndex(int v1){
        return v1 < 0 || v1 >= vertexCount();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < adjList.size(); i++) {
            sb.append(i).append(": ").append(adjList.get(i)).append("\n");
        }
        return sb.toString();
    }
}
