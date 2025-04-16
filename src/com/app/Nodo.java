/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

/**
 *
 * @author bohor
 */

public class Nodo{
    private int id;
    private String nombre;
    private Nodo siguiente;

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.siguiente = null;
    }

    public Nodo(int id, String nombre, Nodo siguiente) {
        this.id = id;
        this.nombre = nombre;
        this.siguiente = siguiente;
    }
    

    public Nodo getSiguiente() {
        return siguiente;
    }

   
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = (Nodo) siguiente;
    }

    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
}
