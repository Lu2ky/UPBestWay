package com.app.Main;

import com.app.conexion.Conexion;
import com.app.manejodatos.Nodo;
import com.app.manejodatos.Grafo;
import com.app.manejodatos.Arista;
import com.app.manejodatos.ListaEnlazada;

import java.sql.SQLException;
import java.sql.PreparedStatement;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bohor
 */
public class Main {
    public static void main(String[] args) {
        
        Conexion cox = new Conexion();
        Grafo grafo = new Grafo(cox);
        grafo.Dijkstra("A", "K", false).MostrarLista();    
    }
}