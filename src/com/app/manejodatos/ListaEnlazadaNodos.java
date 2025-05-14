/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.manejodatos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author bohor
 */
public class ListaEnlazadaNodos implements Iterable<Nodo> {

    private Nodo cabeza;
    private Nodo cola;
    private int size;

    public ListaEnlazadaNodos() {
        this.cabeza = null;
        this.size = 0;
    }

    public ListaEnlazadaNodos(Nodo cabeza) {
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
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
        nuevo.setId(size);
        size++;
    }

    public void agregarNodo2(Nodo nuevo) {
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            cola = nuevo;
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

    public void eliminarNodoBIEN(String nombreNodo) {
        if (cabeza == null) {
            return;
        }

        if (cabeza.getNombre().equals(nombreNodo)) {
            if(cabeza.getSiguiente() == null){
                cabeza = null;
            }
            else{
                cabeza = cabeza.getSiguiente();
            }
            if (cabeza == null) {
                cola = null;
            }
            size--;
            return;
        }
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            Nodo siguiente = actual.getSiguiente();
            if (siguiente.getNombre().equals(nombreNodo)) {
                actual.setSiguiente(siguiente.getSiguiente());
                if (siguiente == cola) {
                    cola = actual;
                }
                size--;
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    public int obtenerIndice(String nombre) {
        Nodo temp = cabeza;
        while (temp != null) {

            if (temp.getNombre().equals(nombre)) {
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
            if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Nodo nodoActual = actual;
        actual = actual.getSiguiente();
        return nodoActual;
        }

    }

    public Nodo getCola() {
        return cola;
    }

    public void setCola(Nodo cola) {
        this.cola = cola;
    }

}
