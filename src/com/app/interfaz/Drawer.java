package com.app.interfaz;

import com.app.conexion.Conexion;
import com.app.manejodatos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Drawer extends JPanel {

    private ListaEnlazadaNodos nodos = new ListaEnlazadaNodos();
    private ListaEnlazadaAristas aristas = new ListaEnlazadaAristas();
    private ListaEnlazadaNodos camino = null;
    private Boolean privilegios;
    private MouseAdapter listener;
    private JTextField nombreNodo;
    private Buffer temp;
    
    public Drawer(Boolean privilegios, Conexion cox, ListaEnlazadaNodos camino, ListaEnlazadaNodos nodos, ListaEnlazadaAristas ar,Buffer buf) {
        temp = buf;
        setPreferredSize(new Dimension(831, 940));
        setBackground(Color.BLACK);
        this.nodos = nodos;
        this.aristas = ar;
        repaint();
    }

    public void setCamino(ListaEnlazadaNodos camino) {
        this.camino = camino;
    }

    public void ponerCamino() {
        aristas = new ListaEnlazadaAristas();
        for (Nodo temp : camino) {
            if (temp.getSiguiente() == null) {
                break;
            }
            aristas.agregarArista(new Arista(temp, temp.getSiguiente(), 0, false));

        }
        repaint();
    }

    public void reiniciarAristas(ListaEnlazadaAristas aris) {
        aristas.setCabeza(aris.getCabeza());
        repaint();
    }

    public Boolean agregarNodo(boolean edicion) {
        privilegios = edicion;
        listener = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && privilegios) {
                    Nodo nuevo = new Nodo(nombreNodo.getText(), e.getX(), e.getY());
                    nodos.agregarNodo(nuevo);
                    temp.getNagregar().push(nodos.getCola());
                    repaint();
                    
                }
                privilegios = false;
            }
            
        };
        this.addMouseListener(listener);
        return temp.getNagregar().peek() != null;
    }
    public void eliminarArista1(String ini, String fin,Buffer buf){
        aristas.eliminarAristaInicioFin(ini, fin,this,buf);
       aristas.eliminarAristaInicioFin(fin, ini,this,buf);
        repaint();
    }
    public void eliminarArista(String nodo,Buffer buf){

        aristas.eliminarAristaInicio(nodo, this, buf);
        repaint();
    }

    public JTextField getNombreNodo() {
        return nombreNodo;
    }

    public void setNombreNodo(JTextField nombreNodo) {
        this.nombreNodo = nombreNodo;
    }

    public ListaEnlazadaAristas getAristas() {
        return aristas;
    }

    public void setAristas(ListaEnlazadaAristas aristas) {
        this.aristas = aristas;
    }

    public ListaEnlazadaNodos getNodos() {
        return nodos;
    }

    public void setNodos(ListaEnlazadaNodos nodos) {
        this.nodos = nodos;
    }

    public Buffer getTemp() {
        return temp;
    }

    public void setTemp(Buffer temp) {
        this.temp = temp;
    }
    

    public void removerEvento() {
        if (listener != null) {
            this.removeMouseListener(listener);
            listener = null;
        }

    }

    public void reiniciar() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        for (Arista temp1 : aristas) {
            int iniX, iniY, finX, finY;
            iniX = temp1.getInicio().getX();
            iniY = temp1.getInicio().getY();
            finX = temp1.getFin().getX();
            finY = temp1.getFin().getY();
            g.drawLine(temp1.getInicio().getX(), temp1.getInicio().getY(), temp1.getFin().getX(), temp1.getFin().getY());
            g.drawLine(finX, finY, finX - 10, finY - 10);
            g.drawLine(finX, finY, finX - 10, finY + 10);
        }

        g.setColor(Color.GRAY);
        for (Nodo temp : nodos) {
            g.fillOval(temp.getX() - 15, temp.getY() - 15, 30, 30);
            g.setColor(new Color(255, 255, 255));
            g.setFont(new java.awt.Font("Roboto Condensed ExtraBold", 0, 15));
            g.drawString(temp.getNombre(), temp.getX() - 15, temp.getY() - 15);
            g.setColor(Color.GRAY);
        }

    }
}
