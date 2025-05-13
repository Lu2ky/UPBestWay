/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.manejodatos;

/**
 *
 * @author bohor
 */

public class Nodo{
    private int id;
    private String nombre;
    private Nodo siguiente;
    private int x;
    private int y;

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.siguiente = null;
    }

    public Nodo(int id, String nombre, Nodo siguiente) {
        this.id = id;
        this.nombre = nombre;
        this.siguiente = siguiente;
    }

    public Nodo(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.siguiente = null;
        this.id = 0; 
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
