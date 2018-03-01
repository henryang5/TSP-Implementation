package com.company;


//Nodes of Linked List in where Edges and Weights are stored
public class Edge<T> {
    private T vertex;
    private int weight;

    Edge(T firstVertex, int weight){
        this.vertex = firstVertex;
        this.weight = weight;
    }

    public T getVertex() {
        return this.vertex;
    }

    public void setVertex(T firstVertex) {
        this.vertex = firstVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
