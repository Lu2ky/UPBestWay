/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.manejodatos;

import com.app.manejodatos.Arista;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.app.manejodatos.PriorityQueue;
import com.app.manejodatos.Stack;
import com.app.manejodatos.Nodo;
import com.app.manejodatos.ListaEnlazadaAristas;
import com.app.manejodatos.ListaEnlazada;
import com.app.conexion.Conexion;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.util.Arrays;

/**
 *
 * @author bohor
 */
public class Grafo {
    private ListaEnlazadaAristas Aristas = new ListaEnlazadaAristas();
    private ListaEnlazada Nodos = new ListaEnlazada();;
    
    public Grafo(Conexion conexion){
        loadDB(conexion);
    }
    
    public void agregarNodo(Nodo nuevo){
        Nodos.agregarNodo(nuevo);
    }
    public void agregarArista(Arista nuevo){
        Aristas.agregarArista(new Arista(nuevo.getFin(),nuevo.getInicio(),nuevo.getPeso(),nuevo.isEscaleras()));
        Aristas.agregarArista(nuevo);
    }
    public ListaEnlazada Dijkstra(String iniS, String finS, boolean escaleras) {
    Nodo ini = Nodos.obtenerNodo(iniS);
    Nodo fn = Nodos.obtenerNodo(finS);
    int[] distancias = new int[Nodos.getSize()];
    ListaEnlazada visitados = new ListaEnlazada();
    int[] padres = new int[Nodos.getSize()];
    Arrays.fill(padres, -1);
    Arrays.fill(distancias, Integer.MAX_VALUE);
    distancias[ini.getId()] = 0;
    
    PriorityQueue pq = new PriorityQueue();
    ListaEnlazadaAristas vecinos = Aristas.obtenerPorInicio(ini.getNombre());
    pq.push(new Arista(null, ini, 0,!escaleras));
    boolean c1 = false;

    while (visitados.getSize() < Nodos.getSize() && !pq.isEmpty()) {
        Arista act = pq.pop();
        Nodo act1 = act.getFin();
        
        
        if (visitados.NodoPresente(act1.getNombre())) {
            continue;
        }
        Nodo act2 = new Nodo( act1.getId(),act1.getNombre() , act1.getSiguiente());
        act2.setSiguiente(null);
        visitados.agregarNodo2(act2);
        
        vecinos = Aristas.obtenerPorInicio(act1.getNombre());
        Arista vec = vecinos.getCabeza();
        
        while (vec != null) {
            if(vec.isEscaleras() == escaleras){
                vec = vec.getSiguiente();
                continue;
            }
            Nodo nodoVecino = vec.getFin();
            int nDis = distancias[act1.getId()] + vec.getPeso();
            
            if (nDis < distancias[nodoVecino.getId()]) {
                distancias[nodoVecino.getId()] = nDis;
                padres[nodoVecino.getId()] = act1.getId();
                pq.push(new Arista(null, nodoVecino, nDis,vec.isEscaleras()));
            }
            
            vec = vec.getSiguiente();
        }
        c1 = true;
    }
    
    System.out.println("Ponderado: " + distancias[fn.getId()] );
    return rCamino(ini, fn, padres);
}
    public ListaEnlazada rCamino(Nodo origen, Nodo destino, int[] padres) {
    ListaEnlazada caminoList = new ListaEnlazada();

    if (origen == null || destino == null || padres == null) {
        return caminoList;
    }

    if (origen.equals(destino)) {
        Nodo copia = new Nodo(origen.getNombre());
        copia.setId(origen.getId());
        caminoList.agregarNodo2(copia);
        return caminoList;
    }
    if (destino.getId() < 0 || destino.getId() >= padres.length || padres[destino.getId()] == -1) {
        return caminoList;
    }

    Stack pila = new Stack();
    int actualId = destino.getId();
    boolean caminoValido = true;
    
   
    while (actualId != -1 && caminoValido) {
        Nodo nodo = Nodos.obtenerNodo(actualId);
        if (nodo == null) {
            caminoValido = false;
            break;
        }

        Nodo copiaNodo = new Nodo(nodo.getNombre());
        copiaNodo.setId(nodo.getId());
        pila.push(copiaNodo);
        
        actualId = padres[actualId];

        if (pila.getTam() > Nodos.getSize()) {
            caminoValido = false;
        }
    }
    if (!caminoValido || pila.isEmpty() || 
        !pila.peek().getNombre().equals(origen.getNombre())) {
        return new ListaEnlazada();
    }

    while (!pila.isEmpty()) {
        Nodo nodo = pila.pop();
        nodo.setSiguiente(null);
        caminoList.agregarNodo2(nodo);
    }
    
    return caminoList;
}

    public ListaEnlazadaAristas getAristas() {
        return Aristas;
    }

    public void setAristas(ListaEnlazadaAristas Aristas) {
        this.Aristas = Aristas;
    }

    public ListaEnlazada getNodos() {
        return Nodos;
    }

    public void setNodos(ListaEnlazada Nodos) {
        this.Nodos = Nodos;
    }
    private void loadDB(Conexion conexion){
        loadNodos(conexion);
        loadAristas(conexion);
    }
    private void loadNodos(Conexion conexion){
        String sql = "SELECT Nombre FROM nodos";
        try(PreparedStatement ps = conexion.getConexion().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                System.out.println("No se encontraron nodos para cargar");
            }
            do{
                Nodo nodo = new Nodo(rs.getString("Nombre"));
                Nodos.agregarNodo(nodo);
            }while(rs.next());
            
        }catch(SQLException e){
            System.out.println("Error al cargar la tabla de nodos");
            e.printStackTrace();
        }
        
    }
    private void loadAristas(Conexion conexion){
        String sql = "SELECT idNodoA, idNodoB, Ponderado, Stairs FROM aristas";
        try(PreparedStatement ps = conexion.getConexion().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                System.out.println("No se encontraron aristas para cargar");
            }
            do{
                Nodo nodo1 = conexion.searchNodo(rs.getInt("idNodoA"));
                nodo1.setId(nodo1.getId() - 1);
                Nodo nodo2 = conexion.searchNodo(rs.getInt("idNodoB"));
                nodo2.setId(nodo2.getId() - 1);
                Aristas.agregarArista(new Arista(nodo1,nodo2,rs.getInt("Ponderado"),rs.getBoolean("Stairs")));
                
                Aristas.agregarArista(new Arista(nodo2,nodo1,rs.getInt("Ponderado"),rs.getBoolean("Stairs")));
            }while(rs.next());
        }catch(SQLException e){
            System.out.println("Error al cargar la tabla de aristas");
            e.printStackTrace();
        }
    }


    
}
