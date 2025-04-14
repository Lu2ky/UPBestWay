/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

/**
 *
 * @author bohor
 */
public class Arista{
    public Nodo inicio;
    public Nodo fin;
    public int peso;
    public Arista siguiente;

    public Arista() {
    }
    public Arista(Nodo inicio, Nodo fin, int peso) {
        this.inicio=inicio;
        this.fin=fin;
        this.peso=peso;
        
    }
    

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    public Arista getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Arista siguiente) {
        this.siguiente = siguiente;
    }
    
}
