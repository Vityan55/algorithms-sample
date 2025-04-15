package org.example.vityan55.graphSample;

/**
 * Some operations with all types of graphs
 */
public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new AdjListGraph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(4, 5);

        Graph digraph = new AdjListDigraph();
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(4, 5);

        System.out.println("AdjListGraph\n" + graph);
        System.out.println("AdjListDigraph\n" + digraph);

        digraph.removeEdge(1, 2);
        graph.removeEdge(1, 2);

        System.out.println("-----------------------");
        System.out.println("AdjListGraph after removing edge (1, 2)\n" + graph);
        System.out.println("AdjListDigraph after removing edge (1, 2)\n" + digraph);

        System.out.println("-----------------------");
        Graph matrixGraph = new AdjMatrixGraph(4);
        matrixGraph.addEdge(3, 1);
        matrixGraph.addEdge(1, 2);
        matrixGraph.addEdge(4, 5);

        Graph matrixDigraph = new AdjMatrixDigraph(4);
        matrixDigraph.addEdge(3, 1);
        matrixDigraph.addEdge(1, 2);
        matrixDigraph.addEdge(4, 5);

        System.out.println("AdjMatrixGraph\n" + matrixGraph);
        System.out.println("AdjMatrixDigraph\n" + matrixDigraph);

        System.out.println("----------------------");

        matrixGraph.removeEdge(1, 2);
        matrixDigraph.removeEdge(1, 2);
        System.out.println("AdjMatrixGraph after removing edge (1, 2)\n" + matrixGraph);
        System.out.println("AdjMatrixDigraph after removing edge (1, 2)\n" + matrixDigraph);

        System.out.println("----------------------");

        Graph graphDfs = new AdjListGraph();
        graphDfs.addEdge(0, 1);
        graphDfs.addEdge(0, 2);
        graphDfs.addEdge(1, 3);
        graphDfs.addEdge(2, 3);
        graphDfs.addEdge(3, 5);
        graphDfs.addEdge(2, 4);

        System.out.println("AdjListGraph for dfs" + graphDfs);
        System.out.println("dfs of AdjListGraph");

        // It must be 0 -> 1 -> 3 -> 2 -> 4 -> 5
        GraphAlgorithms.dfs(graphDfs, 0);

        Graph graphDfs1 = new AdjMatrixGraph();
        graphDfs1.addEdge(0, 3);
        graphDfs1.addEdge(0, 4);
        graphDfs1.addEdge(1, 4);
        graphDfs1.addEdge(2, 3);
        graphDfs1.addEdge(2, 4);
        graphDfs1.addEdge(3, 5);

        System.out.println("AdjMatrixGraph for dfs" + graphDfs1);
        System.out.println("dfs of AdjMatrixGraph");

        // It must be 0 -> 3 -> 2 -> 4 -> 1 -> 5
        GraphAlgorithms.dfs(graphDfs1, 0);
    }
}
