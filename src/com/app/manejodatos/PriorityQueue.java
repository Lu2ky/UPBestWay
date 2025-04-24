/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.manejodatos;

/**
 *
 * @author bohor
 */
public class PriorityQueue {
    private Arista cima;
    private int tam;

    public Arista getCima() {
        return cima;
    }

    public void setCima(Arista cima) {
        this.cima = cima;
    }


    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    
    public void push(Arista nuevaArista){
        if(nuevaArista == null){
            return;
        }
        if(cima == null){
            cima = nuevaArista;
        }
        else if(nuevaArista.getPeso() <= cima.getPeso()){
            nuevaArista.setSiguiente(cima);
            cima = nuevaArista;
        }
        else{
            Arista act = cima;
            Arista ant = null;
            while(act != null && act.getPeso() < nuevaArista.getPeso()){
                ant = act;
                act = act.getSiguiente();
            }
            ant.setSiguiente(nuevaArista);
            nuevaArista.setSiguiente(act);
        }
        tam++;        
    }
    
    public Arista pop(){
        if(cima == null){
            return null;
        }
        Arista temp = cima;
        cima = cima.getSiguiente();
        tam--;
        return temp;
    }
    
    public boolean isEmpty(){
        if(tam == 0 || cima == null){
            return true;
        }
        return false;
    }
    
    
    
}
