package org.example.vityan55.graphSample;

public class GraphAlgorithms {
    public static void dfs (Graph graph, int v){
        boolean[] visited = new boolean[graph.vertexCount()];
        dfs(graph, v, visited);
    }

    public static void dfs (Graph graph, int v, boolean[] visited){
        visited[v] = true;
        System.out.println(v);
        for (int to : graph.getAdjEdges(v)) {
            if (!visited[to]){
                dfs(graph, to, visited);
            }
        }
    }
}
