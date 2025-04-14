/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import java.util.Arrays;

/**
 *
 * @author bohor
 */
public class Grafo {
    private ListaEnlazadaAristas Aristas = new ListaEnlazadaAristas();
    private ListaEnlazada Nodos = new ListaEnlazada();;
    
    public Grafo(){
        
    }
    
    public void agregarNodo(Nodo nuevo){
        Nodos.agregarNodo(nuevo);
    }
    public void agregarArista(Arista nuevo){
        Aristas.agregarArista(new Arista(nuevo.getFin(),nuevo.getInicio(),nuevo.getPeso()));
        Aristas.agregarArista(nuevo);
    }
    public ListaEnlazada Dijkstra(Nodo ini, Nodo fn) {
    int[] distancias = new int[Nodos.getSize()];
    ListaEnlazada visitados = new ListaEnlazada();
    int[] padres = new int[Nodos.getSize()];
    Arrays.fill(padres, -1);
    Arrays.fill(distancias, Integer.MAX_VALUE);
    distancias[ini.getId()] = 0;
    
    PriorityQueue pq = new PriorityQueue();
    ListaEnlazadaAristas vecinos = Aristas.obtenerPorInicio(ini.getNombre());
    pq.push(new Arista(null, ini, 0));

    while (visitados.getSize() < Nodos.getSize() && !pq.isEmpty()) {
        Arista act = pq.pop();
        Nodo act1 = act.getFin();
        
        if (visitados.NodoPresente(act1.getNombre())) {
            continue;
        }
        act1.setSiguiente(null);
        visitados.agregarNodo2(act1);
        
        vecinos = Aristas.obtenerPorInicio(act1.getNombre());
        Arista vec = vecinos.getCabeza();
        
        while (vec != null) {
            Nodo nodoVecino = vec.getFin();
            int nDis = distancias[act1.getId()] + vec.getPeso();
            
            if (nDis < distancias[nodoVecino.getId()]) {
                distancias[nodoVecino.getId()] = nDis;
                padres[nodoVecino.getId()] = act1.getId();
                pq.push(new Arista(null, nodoVecino, nDis));
            }
            
            vec = vec.getSiguiente();
        }
    }
    
    System.out.println("Ponderado: " + distancias[fn.getId()] );
    return rCamino(ini, fn, padres);
}
    public ListaEnlazada rCamino(Nodo origen, Nodo destino, int[] padres) {
    ListaEnlazada caminoList = new ListaEnlazada();
    

    if (origen.equals(destino)) {
        caminoList.agregarNodo2(origen);
        return caminoList;
    }

    if (padres[destino.getId()] == -1) {
        return caminoList;
    }

    Stack pila = new Stack();
    int actualId = destino.getId();
    
    while (actualId != -1) {
        Nodo nodo = Nodos.obtenerNodo(actualId);
        if (nodo == null) break;
        nodo.setSiguiente(null);
        pila.push(nodo);
        actualId = padres[actualId];
    }

    if (pila.isEmpty() || !pila.peek().equals(origen)) {
        return new ListaEnlazada();
    }
    while (!pila.isEmpty()) {
        Nodo n1 = (Nodo) pila.pop();
        n1.setSiguiente(null);
        caminoList.agregarNodo2(n1);
    }
        
    return caminoList;
}
}
