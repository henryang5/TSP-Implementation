package com.company;

import java.util.LinkedList;

public class VertexConnection<T> {
    private T vertex;
    private LinkedList<Edge<T>> edgeList = new LinkedList<Edge<T>>();

    public T getVertex() {
        return vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    public boolean insertEdge(T vertex, int weight){
        if(weight < 0){
            return false;
        }

        Edge edge = new Edge(vertex, weight);
        this.edgeList.add(edge);
        return true;
    }

//    public boolean deleteNode(Edge<T> Node){
//        if(edgeList.remove(Node)){
//            return true;
//        }
//        return false;
//    }

    public VertexConnection<T> getVertexConnection(){
        return this;
    }

    public LinkedList<Edge<T>> getList(){
        return this.edgeList;
    }

}
