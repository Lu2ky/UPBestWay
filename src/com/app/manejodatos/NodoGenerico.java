/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.manejodatos;

import com.app.manejodatos.*;
/**
 *
 * @author bohor
 */
public class NodoGenerico<T> {
    private T valor;
    private NodoGenerico<T> siguiente;

    public NodoGenerico(T valor, NodoGenerico<T> sig) {
        this.valor = valor;
        this.siguiente = sig;
    }

    public NodoGenerico(T valor) {
        this.valor = valor;
    }
    

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoGenerico<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGenerico<T> sig) {
        this.siguiente = sig;
    }
    
    
}
