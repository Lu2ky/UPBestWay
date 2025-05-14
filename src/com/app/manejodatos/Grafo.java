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
import com.app.manejodatos.ListaEnlazadaNodos;
import com.app.conexion.Conexion;
import com.app.interfaz.Drawer;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.awt.TextArea;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author bohor
 */
public class Grafo {
    private ListaEnlazadaAristas Aristas = new ListaEnlazadaAristas();
    private ListaEnlazadaNodos Nodos = new ListaEnlazadaNodos();;
    private Conexion cox = null;
    
    public Grafo(Conexion conexion){
        cox = conexion;
        loadDB(conexion);
    }
    public Grafo(){
        loadDB(cox);
    }
    
    public  void agregarNodo(Nodo nuevo){
        Nodos.agregarNodo(nuevo);
    }
    public void agregarArista(Arista nuevo){
        Aristas.agregarArista(new Arista(nuevo.getFin(),nuevo.getInicio(),nuevo.getPeso(),nuevo.isEscaleras()));
        Aristas.agregarArista(nuevo);
    }
    public ListaEnlazadaNodos Dijkstra(String iniS, String finS, boolean escaleras,JTextArea a, Drawer drawerGrafo) {
        Nodo ini = Nodos.obtenerNodo(iniS);
        Nodo fn = Nodos.obtenerNodo(finS);
        int[] distancias = new int[Nodos.getSize()];
        ListaEnlazadaNodos visitados = new ListaEnlazadaNodos();
        int[] padres = new int[Nodos.getSize()];
        Arrays.fill(padres, -1);
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[ini.getId()] = 0;
    
        PriorityQueue pq = new PriorityQueue();
        ListaEnlazadaAristas vecinos = Aristas.obtenerPorInicio(ini.getNombre());
        pq.push(new Arista(null, ini, 0,!escaleras));   

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
        
        for (Arista vec : vecinos) {
            if(vec.isEscaleras() && escaleras){
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
        }
    }
    
    if(distancias[fn.getId()] < Integer.MAX_VALUE){
        a.append("Metros: " + distancias[fn.getId()] + "\nCamino: ");
        if(distancias[fn.getId()] == 0){
            a.setText("Se encuentra sobre el mismo nodo");
            drawerGrafo.reiniciarAristas(Aristas);
            return new ListaEnlazadaNodos();
        }
    }
    
    else{
        a.append("La ruta entra " + iniS + " y " + finS + " no existe");
        drawerGrafo.reiniciarAristas(Aristas);
        return new ListaEnlazadaNodos();
    }
    return rCamino(ini, fn, padres);
}
    public ListaEnlazadaNodos rCamino(Nodo origen, Nodo destino, int[] padres) {
    ListaEnlazadaNodos caminoList = new ListaEnlazadaNodos();

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

    Stack<Nodo> pila = new Stack();
    int actualId = destino.getId();
    boolean caminoValido = true;
    
   
    while (actualId != -1 && caminoValido) {
        Nodo nodo = Nodos.obtenerNodo(actualId);
        if (nodo == null) {
            caminoValido = false;
            break;
        }

        Nodo copiaNodo = new Nodo(nodo.getNombre());
        copiaNodo.setX(nodo.getX());
        copiaNodo.setY(nodo.getY());
        copiaNodo.setId(nodo.getId());
        pila.push(copiaNodo);
        
        actualId = padres[actualId];

        if (pila.getTam() > Nodos.getSize()) {
            caminoValido = false;
        }
    }
    if (!caminoValido || pila.isEmpty() || 
        !pila.peek().getValor().getNombre().equals(origen.getNombre())) {
        return new ListaEnlazadaNodos();
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

    public ListaEnlazadaNodos getNodos() {
        return Nodos;
    }

    public void setNodos(ListaEnlazadaNodos Nodos) {
        this.Nodos = Nodos;
    }
    private void loadDB(Conexion conexion){
        loadNodos(conexion);
        loadAristas(conexion);
    }
    private void loadNodos(Conexion conexion){
        String sql = "SELECT * FROM nodos";
        try(PreparedStatement ps = conexion.getConexion().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                System.out.println("No se encontraron nodos para cargar");
            }
            do{
                Nodo nodo = new Nodo(rs.getString("Nombre"));
                nodo.setX(rs.getInt("X"));
                nodo.setY(rs.getInt("Y"));
                Nodos.agregarNodo(nodo);
            }while(rs.next());
            
        }catch(SQLException e){
            System.out.println("Error al cargar la tabla de nodos");
            e.printStackTrace();
        }
        
    }
    private void loadAristas(Conexion conexion){
        String sql = "SELECT * FROM aristas AS a RIGHT JOIN nodos AS n ON a.idNodoA = n.idNodo ORDER BY idArista DESC";
        String sql1 = "SELECT * FROM aristas AS a RIGHT JOIN nodos AS n ON a.idNodoB = n.idNodo ORDER BY idArista DESC";       
        try(PreparedStatement ps = conexion.getConexion().prepareStatement(sql)){
            try(PreparedStatement ps1 = conexion.getConexion().prepareStatement(sql1)){
                ResultSet rs = ps.executeQuery();
                ResultSet rs1 = ps1.executeQuery();
                if(!rs.next()){
                    System.out.println("No se encontraron aristas para cargar");
                    return;
                }
                if(!rs1.next()){
                    System.out.println("No se encontraron aristas para cargar");
                    return;
                }
            do{
                Nodo nodo1 = Nodos.obtenerNodo(rs.getString("Nombre"));
                Nodo nodo2 = Nodos.obtenerNodo(rs1.getString("Nombre"));
                Aristas.agregarArista(new Arista(nodo1,nodo2,rs.getInt("Ponderado"),rs.getBoolean("Stairs")));   
                Aristas.agregarArista(new Arista(nodo2,nodo1,rs.getInt("Ponderado"),rs.getBoolean("Stairs")));
                System.out.println(rs.getInt("idArista"));
                
            }while(rs.next() && rs1.next());  
            }
            
            
        }catch(SQLException e){
            System.out.println("Error al cargar la tabla de aristas");
            e.printStackTrace();
        }
    }


    
}
