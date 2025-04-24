/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.manejodatos;

import com.app.manejodatos.Arista;
import com.app.manejodatos.PriorityQueue;
import com.app.manejodatos.Stack;
import com.app.manejodatos.Nodo;
import com.app.manejodatos.ListaEnlazadaAristas;
import com.app.manejodatos.ListaEnlazada;
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
        Aristas.agregarArista(new Arista(nuevo.getFin(),nuevo.getInicio(),nuevo.getPeso(),nuevo.isEscaleras()));
        Aristas.agregarArista(nuevo);
    }
    public ListaEnlazada Dijkstra(Nodo ini, Nodo fn, boolean escaleras) {
    int[] distancias = new int[Nodos.getSize()];
    ListaEnlazada visitados = new ListaEnlazada();
    int[] padres = new int[Nodos.getSize()];
    Arrays.fill(padres, -1);
    Arrays.fill(distancias, Integer.MAX_VALUE);
    distancias[ini.getId()] = 0;
    
    PriorityQueue pq = new PriorityQueue();
    ListaEnlazadaAristas vecinos = Aristas.obtenerPorInicio(ini.getNombre());
    pq.push(new Arista(null, ini, 0,!escaleras));
    boolean c1 = false;

    while (visitados.getSize() < Nodos.getSize() && !pq.isEmpty()) {
        Arista act = pq.pop();
        Nodo act1 = act.getFin();
        
        
        if (visitados.NodoPresente(act1.getNombre())) {
            continue;
        }
        Nodo act2 = new Nodo( act1.getId(),act1.getNombre() , act1.getSiguiente());
        act2.setSiguiente(null);
        visitados.agregarNodo2(act2);
        
        vecinos = Aristas.obtenerPorInicio(act1.getNombre());
        Arista vec = vecinos.getCabeza();
        
        while (vec != null) {
            if(vec.isEscaleras() == escaleras){
                vec = vec.getSiguiente();
                continue;
            }
            Nodo nodoVecino = vec.getFin();
            int nDis = distancias[act1.getId()] + vec.getPeso();
            
            if (nDis < distancias[nodoVecino.getId()]) {
                distancias[nodoVecino.getId()] = nDis;
                padres[nodoVecino.getId()] = act1.getId();
                pq.push(new Arista(null, nodoVecino, nDis,vec.isEscaleras()));
            }
            
            vec = vec.getSiguiente();
        }
        c1 = true;
    }
    
    System.out.println("Ponderado: " + distancias[fn.getId()] );
        System.out.println(Nodos.getCabeza().getSiguiente().getNombre());
    return rCamino(ini, fn, padres);
}
    public ListaEnlazada rCamino(Nodo origen, Nodo destino, int[] padres) {
    ListaEnlazada caminoList = new ListaEnlazada();

    if (origen == null || destino == null || padres == null) {
        return caminoList;
    }

    if (origen.equals(destino)) {
        Nodo copia = new Nodo(origen.getNombre());
        copia.setId(origen.getId());
        caminoList.agregarNodo2(copia);
        return caminoList;
    }
    if (destino.getId() < 0 || destino.getId() >= padres.length || padres[destino.getId()] == -1) {
        return caminoList;
    }

    Stack pila = new Stack();
    int actualId = destino.getId();
    boolean caminoValido = true;
    
   
    while (actualId != -1 && caminoValido) {
        Nodo nodo = Nodos.obtenerNodo(actualId);
        if (nodo == null) {
            caminoValido = false;
            break;
        }

        Nodo copiaNodo = new Nodo(nodo.getNombre());
        copiaNodo.setId(nodo.getId());
        pila.push(copiaNodo);
        
        actualId = padres[actualId];

        if (pila.getTam() > Nodos.getSize()) {
            caminoValido = false;
        }
    }
    if (!caminoValido || pila.isEmpty() || 
        !pila.peek().getNombre().equals(origen.getNombre())) {
        return new ListaEnlazada();
    }

    while (!pila.isEmpty()) {
        Nodo nodo = pila.pop();
        nodo.setSiguiente(null);
        caminoList.agregarNodo2(nodo);
    }
    
    return caminoList;
}

    public ListaEnlazadaAristas getAristas() {
        return Aristas;
    }

    public void setAristas(ListaEnlazadaAristas Aristas) {
        this.Aristas = Aristas;
    }

    public ListaEnlazada getNodos() {
        return Nodos;
    }

    public void setNodos(ListaEnlazada Nodos) {
        this.Nodos = Nodos;
    }
    
}
