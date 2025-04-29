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
import java.sql.SQLException;
import java.util.ArrayList;

public class Drawer extends JPanel {
    private final ArrayList<Point> nodos = new ArrayList<>();
    private ArrayList<Arista> aristas = new ArrayList<>();
    private Point nodoTemporal = null;
    private ListaEnlazada camino = null;

    public Drawer(Boolean privilegios,Conexion cox,ListaEnlazada camino) {
        setPreferredSize(new Dimension(831, 940));
        setBackground(Color.BLACK);
        String sql = "SELECT * FROM nodos ";
        try(PreparedStatement ps = cox.getConexion().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                System.out.println("Error al cargar tabla");
            }
            do{
                rs.getInt("X");
                nodos.add(new Point(rs.getInt("X"),rs.getInt("Y")));
                JLabel text = new JLabel();
                text.setBounds(rs.getInt("X"),rs.getInt("Y"), 90, 90);
                text.setForeground(Color.WHITE);
                this.add(text);
            }while(rs.next());
        
        
       }catch(SQLException e){
           e.printStackTrace(); 
       }
        repaint();
        if(privilegios){
            this.addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    nodos.add(e.getPoint());
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
            g.drawLine(arista.inicio.x, arista.inicio.y, arista.fin.x, arista.fin.y);
        }
        g.setColor(Color.WHITE);
        for (Point nodo : nodos) {
            g.fillOval(nodo.x - 15, nodo.y - 15, 30, 30);
        }
    }

    private static class Arista {
        Point inicio, fin;

        public Arista(Point inicio, Point fin) {
            this.inicio = inicio;
            this.fin = fin;
        }
    }
}