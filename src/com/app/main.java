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
        
        
        
        grafo.agregarArista(new Arista(P1,C,77,false));
        grafo.agregarArista(new Arista(P1,J,60,false));
        grafo.agregarArista(new Arista(C,B,19,false));
        grafo.agregarArista(new Arista(C,D,71,true));
        grafo.agregarArista(new Arista(B,FR,22,true));
        grafo.agregarArista(new Arista(B,A,13,false));
        grafo.agregarArista(new Arista(FR,A,25,true));
        grafo.agregarArista(new Arista(FR,D,42,true));
        grafo.agregarArista(new Arista(D,J,55,false));
        grafo.agregarArista(new Arista(D,P2,136,true));
        grafo.agregarArista(new Arista(P2,E,145,true));
        grafo.agregarArista(new Arista(D,E,66,true));
        grafo.agregarArista(new Arista(D,P2,136,false));
        grafo.agregarArista(new Arista(P2,K,222,true));
        grafo.agregarArista(new Arista(K,J,218,true));
        grafo.agregarArista(new Arista(K,E,139,true));
        grafo.agregarArista(new Arista(J,E,104,true));
        grafo.agregarArista(new Arista(J,F,104,true));
        grafo.agregarArista(new Arista(E,F,25,false));
        grafo.agregarArista(new Arista(E,H,31,false));
        grafo.agregarArista(new Arista(H,ZV,40,false));
        grafo.agregarArista(new Arista(ZV,F,35,false));
        grafo.agregarArista(new Arista(G,ZV,30,false));
        grafo.agregarArista(new Arista(G,H,46,false));
        grafo.agregarArista(new Arista(F,H,40,false));
        grafo.agregarArista(new Arista(G,F,21,false));
        grafo.agregarArista(new Arista(J,G,88,false));
        grafo.agregarArista(new Arista(E,I,144,true));
        grafo.agregarArista(new Arista(I,L,50,false));
        grafo.agregarArista(new Arista(L,K,183,false));
        grafo.agregarArista(new Arista(I,K,152,true));
        grafo.agregarArista(new Arista(D,K,142,true));
        grafo.agregarArista(new Arista(H,L,141,false));
        grafo.agregarArista(new Arista(H,I,84,true));
        
        
        
        
    
        
        
        
        ListaEnlazada camino = grafo.Dijkstra(A, K, true);
        
        System.out.println("Camino mas corto de A a K: ");
        camino.MostrarLista();
        System.out.println("");
        grafo.getNodos().MostrarLista();
        
    }
    
}
