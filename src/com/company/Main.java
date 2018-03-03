package com.company;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Welcome to TSP-Implementation");
        AdjList<String> adjList = new AdjList<String>();

        //Array of vertices to add into adjList
        String initialVertexList[] = {"A", "B", "C", "D", "E"};

        //Initializing Vertices
        adjList.createAdjListSpine(initialVertexList);

        //Initializing Edges
        adjList.addEdge("A", "B", 334);
        adjList.addEdge("A", "C", 612);
        adjList.addEdge("A", "D", 424);
        adjList.addEdge("A", "E",795);

        adjList.addEdge("B", "C", 736);
        adjList.addEdge("B", "D", 202);
        adjList.addEdge("B", "E", 826);
        adjList.addEdge("C", "D",615);

        adjList.addEdge("C", "E", 253);
        adjList.addEdge("D", "E", 657);

        //Prints Representation of Adjacency List
        System.out.println("\nHere is the Adjacency List:");
        adjList.printGraph();

        System.out.print('\n');
        //Nearest Neighbor Algorithm (answer should be 35)
        int sum = adjList.nearestNeighbor(adjList, "A");
        System.out.println("Nearest Neighbor Sum: " + sum);
    }
}
