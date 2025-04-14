/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

/**
 *
 * @author bohor
 */
public class Stack {
    private Nodo cima;
    private int tam;

    public Nodo peek() {
        return cima;
    }

    public void setCima(Nodo cima) {
        this.cima = cima;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    public Nodo pop(){
        if(cima == null){
            return null;
        }
        Nodo temp = cima;
        cima = cima.getSiguiente();
        return temp;
    }
    public boolean isEmpty(){
        if(tam == 0 || cima == null){
            return false;
        }
        return true;
    }
    public void push(Nodo nuevo){
        if(cima == null){
            cima = nuevo;
        }
        else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }
    
    
}
