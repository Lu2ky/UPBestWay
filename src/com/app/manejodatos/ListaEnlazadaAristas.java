/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.manejodatos;

import com.app.interfaz.Buffer;
import com.app.interfaz.Drawer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author bohor
 */
public class ListaEnlazadaAristas implements Iterable<Arista> {

    private Arista cabeza;
    private Arista cola;
    private int size;

    public ListaEnlazadaAristas() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    public ListaEnlazadaAristas(Arista cabeza) {
        this.cabeza = cabeza;
        this.cola = cabeza;
        this.size = 1;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Arista getCabeza() {
        return cabeza;
    }

    public void setCabeza(Arista cabeza) {
        this.cabeza = cabeza;
    }

   public void agregarAristaNofantasma(Arista nuevo) {
    if (nuevo.getPeso() == 0) {
        return;
    }
    if (nuevo.getPeso() < 0) {
        return;
    }

    if (cabeza == null) {
        cabeza = nuevo;
        cola = cabeza;
    } else {
        cola.setSiguiente(nuevo);
        cola = nuevo;
    }
    size++;
}
   public void agregarArista(Arista nuevo) {

    if (cabeza == null) {
        cabeza = nuevo;
        cola = cabeza;
    } else {
        cola.setSiguiente(nuevo);
        cola = nuevo;
    }
    size++;
}

    public ListaEnlazadaAristas obtenerPorInicio(String nombre) {
        ListaEnlazadaAristas vecinos = new ListaEnlazadaAristas();
        if (nombre == null || cabeza == null) {
            return vecinos;
        }

        Arista temp = cabeza;
        while (temp != null) {
            if (temp.getInicio() != null && nombre.equals(temp.getInicio().getNombre())) {
                Arista copia = new Arista(temp.getInicio(), temp.getFin(), temp.getPeso(), temp.isEscaleras());
                vecinos.agregarArista(copia);
            }
            temp = temp.getSiguiente();
        }
        return vecinos;
    }

    public void MostrarLista() {
        Arista temp = cabeza;
        while (temp != null) {
            System.out.println(temp.getInicio().getNombre() + "->" + temp.getFin().getNombre() + "; " + temp.getPeso());
            temp = temp.getSiguiente();
        }
    }

    public ListaEnlazadaAristas eliminarAristaInicioFin(String nombreINI, String nombreFIN, Drawer draw, Buffer buf) {
        ListaEnlazadaAristas tempLE = new ListaEnlazadaAristas();
        while (cabeza != null && cabeza.getInicio().getNombre().equals(nombreINI) && cabeza.getFin().getNombre().equals(nombreFIN)) {
            if (cabeza.getSiguiente() == null) {
                cabeza = null;
            } else {
                buf.getAeliminar().push(cabeza);
                tempLE.agregarArista(cabeza);
                cabeza = cabeza.getSiguiente();

            }
            if (cabeza == null) {
                cola = null;
            }
            size--;

        }
        Arista temp = cabeza;
        while (temp.getSiguiente() != null) {
            Arista siguiente = temp.getSiguiente();
            if (siguiente.getInicio().getNombre().equals(nombreINI)
                    && siguiente.getFin().getNombre().equals(nombreFIN)) {
                // Remove the node
                buf.getAeliminar().push(siguiente);
                System.out.println(buf.getAeliminar().peek().getValor().getPeso());
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                size--;
            } else {
                temp = temp.getSiguiente();
            }
        }

        actualizarCola();
        draw.reiniciar();
        return tempLE;
    }

    public ListaEnlazadaAristas eliminarAristaInicio(String nombreINI, Drawer draw, Buffer buf) {
        ListaEnlazadaAristas tempLE = new ListaEnlazadaAristas();
        while (cabeza != null && cabeza.getInicio().getNombre().equals(nombreINI)) {
            buf.getAeliminar().push(cabeza);
            tempLE.agregarArista(cabeza);
            cabeza = cabeza.getSiguiente();
            if (cabeza == null) {
                cola = null;
            }
            size--;
        }
        Arista temp = cabeza;
        while (temp != null && temp.getSiguiente() != null) {
            String nombre1 = temp.getSiguiente().getInicio().getNombre();
            if (nombre1.equals(nombreINI)) {
                buf.getAeliminar().push(temp.getSiguiente());
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                size--;
                draw.reiniciar();
            } else {
                temp = temp.getSiguiente();
            }

        }
        actualizarCola();
        eliminarAristaFin(nombreINI, draw, buf);
        return tempLE;
    }

    public ListaEnlazadaAristas eliminarAristaFin(String nombreFIN, Drawer draw, Buffer buf) {
        ListaEnlazadaAristas tempLE = new ListaEnlazadaAristas();
        while (cabeza != null && cabeza.getFin().getNombre().equals(nombreFIN)) {
            buf.getAeliminar().push(cabeza);
            tempLE.agregarArista(cabeza);
            cabeza = cabeza.getSiguiente();
            if (cabeza == null) {
                cola = null;
            }
            size--;
        }
        Arista temp = cabeza;
        while (temp != null && temp.getSiguiente() != null) {
            String nombre1 = temp.getSiguiente().getFin().getNombre();
            if (nombre1.equals(nombreFIN)) {
                buf.getAeliminar().push(temp.getSiguiente());
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                size--;
                draw.reiniciar();
            } else {
                temp = temp.getSiguiente();
            }

        }
        actualizarCola();
        return tempLE;
    }

    public ListaEnlazadaAristas eliminarAristasDeNodo(String nombreNodo, Drawer draw, Buffer buf) {
        ListaEnlazadaAristas eliminadas = new ListaEnlazadaAristas();
        while (cabeza != null && (nombreNodo.equals(cabeza.getInicio().getNombre()) || nombreNodo.equals(cabeza.getFin().getNombre()))) {
            buf.getAeliminar().push(cabeza);
            eliminadas.agregarArista(cabeza);
            cabeza = cabeza.getSiguiente();
            if (cabeza == null) {
                cola = null;
            }
            size--;
        }

        Arista actual = cabeza;
        while (actual != null && actual.getSiguiente() != null) {
            Arista siguiente = actual.getSiguiente();
            if (nombreNodo.equals(siguiente.getInicio().getNombre())
                    || nombreNodo.equals(siguiente.getFin().getNombre())) {

                buf.getAeliminar().push(siguiente);
                eliminadas.agregarArista(siguiente);

                actual.setSiguiente(siguiente.getSiguiente());
                siguiente.setSiguiente(null);
                size--;
            }
            actual = actual.getSiguiente();
        }
        draw.reiniciar();
        return eliminadas;
    }

    private void actualizarCola() {
        cola = null;
        Arista temp = cabeza;
        while (temp != null) {
            if (temp.getSiguiente() == null) {
                cola = temp;
            }
            temp = temp.getSiguiente();
        }
    }

    @Override
    public Iterator<Arista> iterator() {
        return new IteratorListaAristas();
    }

    private class IteratorListaAristas implements Iterator<Arista> {

        private Arista actual = cabeza;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public Arista next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Arista nodoActual = actual;
            actual = actual.getSiguiente();
            return nodoActual;
        }
    }
}
