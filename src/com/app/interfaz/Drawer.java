package com.app.interfaz;

import com.app.conexion.Conexion;
import com.app.manejodatos.ListaEnlazada;
import com.app.manejodatos.Nodo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Drawer extends JPanel {
    private ListaEnlazada nodos = new ListaEnlazada();
    private ArrayList<Arista> aristas = new ArrayList<>();
    private Point nodoTemporal = null;
    private ListaEnlazada camino = null;

    public Drawer(Boolean privilegios,Conexion cox,ListaEnlazada camino,ListaEnlazada nodos) {
        setPreferredSize(new Dimension(831, 940));
        setBackground(Color.BLACK);
        this.nodos = nodos;
        
        if(privilegios){
            //Privilegios de administrador
            this.addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    nodos.agregarNodo(e.getPoint());
                    System.out.println(e.getX() + " " + e.getY());
                    repaint();
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    for (Point nodo : nodos) {
                        if (nodo.distance(e.getPoint()) <= 15) {
                            nodoTemporal = nodo;
                            return;
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && nodoTemporal != null) {
                    for (Point nodo : nodos) {
                        if (nodo.distance(e.getPoint()) <= 15 && !nodo.equals(nodoTemporal)) {
                            aristas.add(new Arista(nodoTemporal, nodo));
                            break;
                        }
                    }
                    nodoTemporal = null;
                    repaint();
                }
            }
        });
        }
    repaint();    
    }
    public void setCamino(ListaEnlazada camino) {
        this.camino = camino;
    }
    public void ponerCamino(){
        aristas = new ArrayList<>();
        Nodo temp = camino.getCabeza();
        while(temp.getSiguiente() != null){
            Point puntoA = new Point(temp.getX(),temp.getY());
            Point puntoB = new Point(temp.getSiguiente().getX(),temp.getSiguiente().getY());
            aristas.add(new Arista(puntoA, puntoB));
            temp = temp.getSiguiente();
            
        }
        repaint();
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        for (Arista arista : aristas) {
            Point puntoA, puntoB, puntoC = new Point();
            int iniX,iniY,finX,finY;
            iniX = (int) arista.getInicio().getX(); iniY = (int) arista.getInicio().getY();
            finX = (int) arista.getInicio().getX(); finY = (int) arista.getInicio().getY();      
            double distanciaAB = sqrt(pow(finX-iniX, 2) + pow(finY-finX,2));
            double distanciaAC = sqrt(pow(iniX ,2) + pow(finY, 3));
            double tetha = acos(distanciaAC/distanciaAB);
            double distanciaCB = distanciaAC/tan(tetha);
            g.drawLine(finX/10, finY, finX, finY);
            g.drawLine( (int) arista.getInicio().getX(),(int) arista.getInicio().getY(), (int) arista.getFin().getX(), (int) arista.getFin().getY());
            
        }
        g.setColor(Color.WHITE);
        Nodo temp = nodos.getCabeza();
        while(temp != null){
            g.fillOval(temp.getX() - 15, temp.getY() - 15, 21, 21);
            temp = temp.getSiguiente();
        }
        
        
    }

    private static class Arista {
        Point inicio, fin;

        public Arista(Point inicio, Point fin) {
            this.inicio = inicio;
            this.fin = fin;
        }

        public Point getInicio() {
            return inicio;
        }

        public void setInicio(Point inicio) {
            this.inicio = inicio;
        }

        public Point getFin() {
            return fin;
        }

        public void setFin(Point fin) {
            this.fin = fin;
        }
        
    }
}