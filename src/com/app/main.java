/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

/**
 *
 * @author bohor
 */
public class main {
    public static void main(String[] args){
        Grafo grafo = new Grafo();
        Nodo A = new Nodo("A");
        Nodo B = new Nodo("B");
        Nodo C = new Nodo("C");
        Nodo D = new Nodo("D");
        Nodo E = new Nodo("E");
        Nodo F = new Nodo("F");
        Nodo G = new Nodo("G");
        Nodo H = new Nodo("H");
        Nodo I = new Nodo("I");
        Nodo J = new Nodo("J");
        Nodo K = new Nodo("K");
        Nodo L = new Nodo("L");
        Nodo FR = new Nodo("FR");
        Nodo P1 = new Nodo("P1");
        Nodo P2 = new Nodo("P2");
        Nodo ZV = new Nodo("ZV");
        
        grafo.agregarNodo(A);
        grafo.agregarNodo(B);
        grafo.agregarNodo(C);
        grafo.agregarNodo(D);
        grafo.agregarNodo(E);
        grafo.agregarNodo(F);
        grafo.agregarNodo(G);
        grafo.agregarNodo(H);
        grafo.agregarNodo(I);
        grafo.agregarNodo(J);
        grafo.agregarNodo(K);
        grafo.agregarNodo(L);
        grafo.agregarNodo(FR);
        grafo.agregarNodo(P1);
        grafo.agregarNodo(P2);
        grafo.agregarNodo(ZV);
        
        
        
        grafo.agregarArista(new Arista(P1,C,77));
        grafo.agregarArista(new Arista(P1,J,60));
        grafo.agregarArista(new Arista(C,B,19));
        grafo.agregarArista(new Arista(C,D,71));
        grafo.agregarArista(new Arista(B,FR,22));
        grafo.agregarArista(new Arista(B,A,13));
        grafo.agregarArista(new Arista(FR,A,25));
        grafo.agregarArista(new Arista(FR,D,42));
        grafo.agregarArista(new Arista(D,J,55));
        grafo.agregarArista(new Arista(D,P2,136));
        grafo.agregarArista(new Arista(P2,E,145));
        grafo.agregarArista(new Arista(D,E,66));
        grafo.agregarArista(new Arista(D,P2,136));
        grafo.agregarArista(new Arista(P2,D,222));
        grafo.agregarArista(new Arista(K,J,218));
        grafo.agregarArista(new Arista(K,E,139));
        grafo.agregarArista(new Arista(J,E,104));
        grafo.agregarArista(new Arista(J,F,104));
        grafo.agregarArista(new Arista(E,F,25));
        grafo.agregarArista(new Arista(E,H,31));
        grafo.agregarArista(new Arista(H,ZV,40));
        grafo.agregarArista(new Arista(ZV,F,35));
        grafo.agregarArista(new Arista(G,ZV,30));
        grafo.agregarArista(new Arista(G,H,46));
        grafo.agregarArista(new Arista(F,H,40));
        grafo.agregarArista(new Arista(G,F,21));
        grafo.agregarArista(new Arista(J,G,88));
        grafo.agregarArista(new Arista(E,I,144));
        grafo.agregarArista(new Arista(I,L,50));
        grafo.agregarArista(new Arista(L,K,183));
        grafo.agregarArista(new Arista(I,K,152));
        grafo.agregarArista(new Arista(D,K,142));
        
        
        
        
    
        
        
        
        ListaEnlazada camino = grafo.Dijkstra(A, K);
        
        System.out.println("Camino mas corto de A a K: ");
        camino.MostrarLista();
        
    }
    
}
