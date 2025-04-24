/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.manejodatos;

import com.app.manejodatos.Nodo;

/**
 *
 * @author bohor
 */
public class Arista{
    public Nodo inicio;
    public Nodo fin;
    public int peso;
    public Arista siguiente;
    public boolean escaleras;

    public Arista() {
    }
    public Arista(Nodo inicio, Nodo fin, int peso,boolean escaleras) {
        this.inicio=inicio;
        this.fin=fin;
        this.peso=peso;
        this.escaleras = escaleras;
        
    }

    public boolean isEscaleras() {
        return escaleras;
    }

    public void setEscaleras(boolean escaleras) {
        this.escaleras = escaleras;
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
