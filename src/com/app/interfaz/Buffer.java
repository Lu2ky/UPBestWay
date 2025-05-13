/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.interfaz;

import com.app.manejodatos.Nodo;
import com.app.manejodatos.Arista;
import com.app.manejodatos.Stack;

/**
 *
 * @author bohor
 */
public class Buffer {
    private Stack<Nodo> Nagregar;
    private Stack<Nodo> Neliminar;
    private Stack<Arista> Aagregar;
    private Stack<Arista> Aeliminar;

    public Buffer() {
        Nagregar = new Stack<>();
        Neliminar = new Stack<>();
        Aagregar = new Stack<>();
        Aeliminar = new Stack<>();
    }

    public Stack<Nodo> getNagregar() {
        return Nagregar;
    }

    public void setNagregar(Stack<Nodo> Nagregar) {
        this.Nagregar = Nagregar;
    }

    public Stack<Nodo> getNeliminar() {
        return Neliminar;
    }

    public void setNeliminar(Stack<Nodo> Neliminar) {
        this.Neliminar = Neliminar;
    }

    public Stack<Arista> getAagregar() {
        return Aagregar;
    }

    public void setAagregar(Stack<Arista> Aagregar) {
        this.Aagregar = Aagregar;
    }

    public Stack<Arista> getAeliminar() {
        return Aeliminar;
    }

    public void setAeliminar(Stack<Arista> Aeliminar) {
        this.Aeliminar = Aeliminar;
    }
    
    
}
