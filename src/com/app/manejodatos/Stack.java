/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.manejodatos;

import java.util.Iterator;

/**
 *
 * @author bohor
 * @param <T>
 */
public class Stack<T> implements Iterable<T> {

    private NodoGenerico<T> cima;
    private int tam;

    public Stack() {
        cima = null;
        this.tam = 0;
    }

    public NodoGenerico<T> peek() {
        return cima;
    }

    public void setCima(NodoGenerico<T> cima) {
        this.cima = cima;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public T pop() {
        if (cima == null) {
            return null;
        }
        T temp = cima.getValor();
        cima = cima.getSiguiente();
        tam--;
        return temp;
    }

    public boolean isEmpty() {
        return tam == 0 || cima == null;
    }

    public void push(T nuevo) {
        NodoGenerico<T> n = new NodoGenerico(nuevo);
        if (cima == null) {
            cima = n;
        } else {
            n.setSiguiente(cima);
            cima = n;
        }
        tam++;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorDeStack();
    }


    private class IteradorDeStack implements Iterator<T> {

        private NodoGenerico<T> actual = peek();

        @Override
        public boolean hasNext() {
            return !isEmpty();
        }

        @Override
        public T next() {
            T valor = pop();
            actual = actual.getSiguiente();
            return valor;
        }

    }

}
