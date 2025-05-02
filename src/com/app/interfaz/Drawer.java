package com.app.interfaz;

import com.app.conexion.Conexion;
import com.app.manejodatos.Arista;
import com.app.manejodatos.ListaEnlazada;
import com.app.manejodatos.ListaEnlazadaAristas;
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
    private ListaEnlazadaAristas aristas = new ListaEnlazadaAristas();
    private ListaEnlazada camino = null;

    public Drawer(Boolean privilegios,Conexion cox,ListaEnlazada camino,ListaEnlazada nodos,ListaEnlazadaAristas ar) {
        setPreferredSize(new Dimension(831, 940));
        setBackground(new java.awt.Color(144,0,0));
        this.nodos = nodos;
        this.aristas = ar;
        repaint();    
    }
    public void setCamino(ListaEnlazada camino) {
        this.camino = camino;
    }
    public void ponerCamino(){
        aristas = new ListaEnlazadaAristas();
        Nodo temp = camino.getCabeza();
        while(temp.getSiguiente() != null){
            aristas.agregarArista(new Arista(temp,temp.getSiguiente(),0,false));
            temp = temp.getSiguiente();
            
        }
        repaint();
    }
    public void reiniciarAristas(ListaEnlazadaAristas aris){
        aristas = aris;
        repaint();
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        Arista temp1 = aristas.getCabeza();
        
        while(temp1 != null){
            int iniX,iniY,finX,finY; iniX = temp1.getInicio().getX(); iniY = temp1.getInicio().getY(); finX = temp1.getFin().getX(); finY = temp1.getFin().getY();
    
            g.drawLine(temp1.getInicio().getX(), temp1.getInicio().getY(), temp1.getFin().getX(), temp1.getFin().getY());
            g.drawLine(finX, finY, finX - 10 , finY - 10);
            g.drawLine(finX, finY, finX - 10 , finY + 10);
            
            temp1 = temp1.getSiguiente();
        }
        
        g.setColor(Color.BLACK);
        Nodo temp = nodos.getCabeza();
        while(temp != null){
            g.fillOval(temp.getX() - 15, temp.getY() - 15, 30, 30);
            g.setColor(Color.BLUE);
            g.drawString(temp.getNombre(), temp.getX() - 15, temp.getY() - 15);
            g.setColor(Color.BLACK);
            temp = temp.getSiguiente();
        }
        
        
    }
}