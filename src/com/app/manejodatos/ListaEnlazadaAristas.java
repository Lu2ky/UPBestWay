/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.manejodatos;

/**
 *
 * @author bohor
 */
public class ListaEnlazadaAristas {
    private Arista cabeza;
    private int size;

    public ListaEnlazadaAristas() {
        this.cabeza = null;
        this.size = 0;
    }

    public ListaEnlazadaAristas(Arista cabeza) {
        this.cabeza = cabeza;
        size=1;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void agregarArista(Arista nuevo) {
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Arista temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevo);
        }
        size++;
    }
    public ListaEnlazadaAristas obtenerPorInicio(String nombre) {
        if(nombre == null){
            return null;
        }
            
        ListaEnlazadaAristas vecinos = new ListaEnlazadaAristas();
        if(cabeza == null){
            return vecinos;
        }
        
        Arista temp = cabeza;
        while(temp != null){
            if(nombre.equals(temp.getInicio().getNombre()) && temp.getInicio() != null){
                Arista temp2 = new Arista(temp.getInicio(),temp.getFin(),temp.getPeso(),temp.isEscaleras());
                vecinos.agregarArista(temp2);
            }
            temp = temp.getSiguiente();
        }
        return vecinos;
    }
    public void MostrarLista(){
        Arista temp=cabeza;
        while(temp!=null){
            System.out.println(temp.getInicio().getNombre()+ "->" + temp.getFin().getNombre() + "; " + temp.getPeso());
            temp = temp.getSiguiente();
        }
        return;
    }

    public Arista getCabeza() {
        return cabeza;
    }

    public void setCabeza(Arista cabeza) {
        this.cabeza = cabeza;
    }
    
    
}
