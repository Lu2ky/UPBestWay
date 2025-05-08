/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.manejodatos;

import java.util.Iterator;

/**
 *
 * @author bohor
 */
public class ListaEnlazada implements Iterable<Nodo> {

    private Nodo cabeza;
    private int size;

    public ListaEnlazada() {
        this.cabeza = null;
        this.size = 0;
    }

    public ListaEnlazada(Nodo cabeza) {
        this.cabeza = cabeza;
        cabeza.setId(0);
        size++;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void agregarNodo(Nodo nuevo) {
        if (nuevo == null) {
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

    public boolean eliminarNodo(String nombre) {
        if (cabeza == null) {
            return false;
        }
        if (cabeza.getNombre().equals(nombre)) {
            cabeza = cabeza.getSiguiente();
            size--;
            return true;
        }
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            Nodo siguiente = (Nodo) actual.getSiguiente();
            if (siguiente.getNombre().equals(nombre)) {
                actual.setSiguiente(siguiente.getSiguiente());
                size--;
                return true;
            }
            actual = siguiente;
        }
        return false;
    }

    public void eliminarNodoBIEN(String nombreNodo){
        if(cabeza.getNombre().equals(nombreNodo)){
            Nodo temp = cabeza.getSiguiente();
            cabeza = temp;
            size--;
            return;
        }
        Nodo temp = cabeza;
        while(temp.getSiguiente() != null){
            if(temp.getSiguiente().getNombre().equals(nombreNodo)){
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                size--;
                return;
            }
            temp = temp.getSiguiente();
        }
    }

    public int obtenerIndice(String nombre) {
        Nodo temp = cabeza;
        while (temp != null) {

            if (temp.getNombre() == nombre) {
                return temp.getId();
            }
            temp = temp.getSiguiente();
        }
        return -1;
    }

    public Nodo obtenerNodo(int id) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.getId() == id) {
                break;
            }
            temp = temp.getSiguiente();
        }
        return temp;
    }

    public Nodo obtenerNodo(String nombre) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.getNombre().equals(nombre)) {
                break;
            }
            temp = temp.getSiguiente();
        }
        return temp;
    }

    public void MostrarLista() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.getNombre() + " ");
            temp = temp.getSiguiente();
        }
        return;
    }

    public boolean NodoPresente(String nombre) {
        if (cabeza == null) {
            return false;
        }
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.getNombre().equals(nombre)) {
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

    @Override
    public Iterator<Nodo> iterator() {
        return new IteratorListaNodos();
    }
    
    private class IteratorListaNodos implements Iterator<Nodo> {
        
        private Nodo actual = cabeza;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public Nodo next() {
            Nodo nodoActual = actual;
            actual = actual.getSiguiente();
            return nodoActual;
        }
        
    }

}
