package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Adjacency List Implementation based on File Reading
    //Example:
        //  ArrayList of Linked Lists of Edges(Type of Node, unsigned int Weight)
        //      |1| => |1/45| -> |2/25|
        //      |2| => |1/25| -> |3/40|
        //      |3| => |2/40|

public class AdjList<T> {
    private ArrayList<VertexConnection<T>> adjList = new ArrayList<VertexConnection<T>>();
    private HashMap<T, Integer> vertexMap = new HashMap<T, Integer>();

    //Inserts node in the graph
    //Returns True if the node was successfully deleted
    public boolean createAdjListSpine(T vertexList[]){

        //Rather than passing in a VertexConnection, we should create one and use a constructor to implement it.
        for(int i = 0; i < vertexList.length; i++){
            VertexConnection<T> vertexConnection = new VertexConnection<>();
            vertexConnection.setVertex(vertexList[i]);
            adjList.add(vertexConnection);
            vertexMap.put(vertexList[i], i);
        }

        return true;
    }

    public HashMap<T, Integer> getVertexMap(){
        return vertexMap;
    }

    public boolean addEdge(T firstVertex, T secondVertex, int weight){
        if(weight < 0){
            return false;
        }
        for(int i = 0; i < adjList.size(); i++){
            if(adjList.get(i).getVertexConnection().getVertex() == firstVertex){
                //add edge to the vertex connection
                adjList.get(i).getVertexConnection().insertEdge(secondVertex, weight);
            }
            else if(adjList.get(i).getVertexConnection().getVertex() == secondVertex){
                adjList.get(i).getVertexConnection().insertEdge(firstVertex, weight);
            }
        }

        return false;
    }

    //Deletes node in the graph
    //Returns True if node was successfully deleted
    //Note: Consider How you will find this node in the array list (most likely based off index)
    public boolean deleteNode(T Edge){
        //stub
        assert(false);
        return false;
    }

    //Creates visual representation of Graph through Adjacency List similar to example provided above
    public void printGraph(){
        for(int i = 0; i < adjList.size(); i++) {
            System.out.print(adjList.get(i).getVertex());
            System.out.print(" | ");
            for(int j = 0; j < adjList.get(i).getVertexConnection().getList().size(); j++) {
                System.out.print(adjList.get(i).getVertexConnection().getList().get(j).getVertex());
                System.out.print(':');
                System.out.print(adjList.get(i).getVertexConnection().getList().get(j).getWeight());
                System.out.print(" -> ");
            }
            System.out.print("NULL\n");
        }
    }

    //Gets a vertex (if it exists)
    //Returns position of a vertex
    public int getVertexPosition(T vertex){
        for(int i = 0; i < adjList.size(); i++){
            if(vertex == adjList.get(i).getVertexConnection().getVertex()){
                return i;
            }
        }
        return -1;
    }

    //Grabs weight between two edges
    //Returns value of weight
    //Returns -1 if one of passed vertices does not exist or if the two vertices are not connected
    public int getWeight(T firstVertex, T secondVertex){
        int positionFirstVertex = this.getVertexPosition(firstVertex);
        int positionSecondVertex = this.getVertexPosition(secondVertex);

        if(positionFirstVertex == -1 || positionSecondVertex == -1){
            //One of the vertices does not exist
            return -1;
        }

        //check the adjList at the position of firstVertex for the connection
        for(int i = 0; i < adjList.get(positionFirstVertex).getVertexConnection().getList().size(); i++) {
            if(adjList.get(positionFirstVertex).getVertexConnection().getList().get(i).getVertex() == secondVertex){
                return adjList.get(positionFirstVertex).getVertexConnection().getList().get(i).getWeight();
            }
        }

        //Vertices are not connected
        return -1;
    }

    //Getter to return adjList
    ArrayList<VertexConnection<T>> getAdjList(){
        return this.adjList;
    }

    //Nearest Neighbor Algorithm
    //Returns sum of weights for the path taken
    //If all nodes are not visited, returns -1
    public int nearestNeighbor(AdjList<T> Graph, T startVertex){
        final int MAX_INT = 0xFFFFFFF; //value is not unsigned thus using 7 Hex Fs
        int sum = 0;

        Set<T> visitedSet = new HashSet<T>();
        visitedSet.add(startVertex);

        //secret message: are you watching me lol....cuz I'm watching you ({O.O})

        int numVisited = visitedSet.size();
        int minWeight = MAX_INT;
        int numberOfVertices = Graph.getAdjList().size();
        T minEdge = startVertex;

        int index = Graph.getVertexMap().get(startVertex);

        for(int i = 0; i < numberOfVertices; i++){
            for(int j = 0; j < Graph.getAdjList().get(index).getList().size(); j++) {
                if(minWeight > Graph.getAdjList().get(index).getList().get(j).getWeight() &&
                        !visitedSet.contains(Graph.getAdjList().get(index).getList().get(j).getVertex())){
                    minWeight = Graph.getAdjList().get(index).getList().get(j).getWeight();
                    minEdge = Graph.getAdjList().get(index).getList().get(j).getVertex();
                }
            }
            if(visitedSet.size() != numberOfVertices) {
                sum = sum + minWeight;
                index = Graph.getVertexMap().get(minEdge);
                visitedSet.add(minEdge);
            }
        }

        //All nodes are unable to be visited without revisiting nodes
        if(visitedSet.size() != numberOfVertices){
            return -1;
        }

        return sum;
    }
}
