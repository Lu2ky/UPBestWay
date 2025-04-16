/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

/**
 *
 * @author bohor
 */


public class ListaEnlazada {
    private Nodo cabeza;
    private int size;

    public ListaEnlazada() {
        this.cabeza = null;
        this.size = 0;
    }

    public ListaEnlazada(Nodo cabeza) {
        this.cabeza = cabeza;
        cabeza.setId(0);
        size=1;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void agregarNodo(Nodo nuevo) {
        if(nuevo == null){
            return;
        }
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = (Nodo) temp.getSiguiente();
            }
            temp.setSiguiente(nuevo);
        }
        nuevo.setId(size);
        size++;
    }
    public void agregarNodo2(Nodo nuevo) {
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = (Nodo) temp.getSiguiente();
            }
            temp.setSiguiente(nuevo);
        }
        size++;
    }
    public int obtenerIndice(String nombre) {
        Nodo temp = cabeza;
        while (temp != null) {
            
            if (temp.getNombre() == nombre){
                return temp.getId();
            }
            temp = temp.getSiguiente();
        }
        return -1;
    }
    public Nodo obtenerNodo(int id){
        Nodo temp=cabeza;
        while (temp != null) {
            if (temp.getId() == id){
                break;
            }
            temp =temp.getSiguiente();
        }
        return temp;
    }
    public void MostrarLista(){
        Nodo temp=cabeza;
        while(temp!=null){
            System.out.print(temp.getNombre() + ",");
            temp = temp.getSiguiente();
        }
        return;
    }
    public boolean NodoPresente(String nombre){
        if(cabeza == null){
         return false;
        }
        Nodo temp = cabeza;
        while(temp != null){
            if(temp.getNombre().equals(nombre)){
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
    
    
}