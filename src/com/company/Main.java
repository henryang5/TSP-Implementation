package com.company;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Welcome to TSP-Implementation");
        AdjList<String> adjList = new AdjList<String>();

        //Array of vertices to add into adjList
        String initialVertexList[] = {"A", "B", "C", "D"};

        //Initializing Vertices
        adjList.createAdjListSpine(initialVertexList);

        //Initializing Edges
        adjList.addEdge("A", "B", 10);
        adjList.addEdge("A", "D", 20);
        adjList.addEdge("B", "C",5);

        //Prints Representation of Adjacency List
        System.out.println("\nHere the Adjacency List");
        adjList.printGraph();

        System.out.print('\n');
        //Nearest Neighbor Algorithm (answer should be 35)
        int sum = adjList.nearestNeighbor(adjList, "D");
        System.out.println("\nNearest Neighbor Sum: " + sum);
    }
}
