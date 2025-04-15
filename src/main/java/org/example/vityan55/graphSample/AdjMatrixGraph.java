package org.example.vityan55.graphSample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjMatrixGraph implements Graph{
    private boolean[][] adjMatrix;
    private int edgeCount;
    private int vertexCount;

    /**
     * Constructor with vertexes count
     * @param vertexCount Count of vertexes
     */
    public AdjMatrixGraph(int vertexCount) {
        if (vertexCount < 0){
            throw new IllegalArgumentException("Wrong index " + vertexCount);
        }
        adjMatrix = new boolean[vertexCount][vertexCount];
        this.vertexCount = vertexCount;
    }

    /**
     * Constructor that's create a graph with one vertex
     */
    public AdjMatrixGraph() {
        adjMatrix = new boolean[0][0];
    }

    @Override
    public int edgeCount() {
        return edgeCount;
    }

    @Override
    public int vertexCount() {
        return vertexCount;
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0){
            throw new IllegalArgumentException("Index must be non-negative");
        }

        int maxV = Math.max(v1, v2);
        if (maxV >= vertexCount) {
            adjMatrix = Arrays.copyOf(adjMatrix, maxV + 1);
            for (int i = 0; i <= maxV; i++) {
                adjMatrix[i] = i < vertexCount ?
                        Arrays.copyOf(adjMatrix[i], maxV + 1) : new boolean[maxV + 1];
            }
            vertexCount = maxV + 1;
        }

        if (!adjMatrix[v1][v2]) {
            adjMatrix[v1][v2] = true;
            if (!(this instanceof Digraph)) {
                adjMatrix[v2][v1] = true;
            }
            edgeCount++;
        }
    }

    @Override
    public void removeEdge(int v1, int v2) {
        if (isInvalidIndex(v1) || isInvalidIndex(v2)) {
            throw new IllegalArgumentException("Wrong index of removable edge");
        }

        if (adjMatrix[v1][v2]) {
            adjMatrix[v1][v2] = false;
            if (!(this instanceof Digraph)) {
                adjMatrix[v2][v1] = false;
            }
            edgeCount--;
        }
    }

    @Override
    public List<Integer> getAdjEdges(int v1) {
        if (isInvalidIndex(v1)){
            throw new IllegalArgumentException("Wrong index " + v1);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[v1][i]){
                result.add(i);
            }
        }
        return result;
    }

    /**
     *
     * @param v1 Vertex to check
     * @return Is invalid index
     */
    private boolean isInvalidIndex(int v1){
        return v1 < 0 || v1 >= vertexCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertexCount; i++) {
            sb.append(i).append(" [ ");
            for (int j = 0; j < vertexCount; j++) {
                if (adjMatrix[i][j]){
                    sb.append(j).append(" ");
                }
            }
            sb.append("]").append("\n");
        }
        return sb.toString();
    }
}