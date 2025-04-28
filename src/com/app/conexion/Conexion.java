 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.app.manejodatos.Nodo;
import com.app.conexion.data.enumData;
import java.awt.Color;
import javax.swing.JLabel;
import com.app.manejodatos.ListaEnlazada;

public class Conexion{
       private Connection conexion;
       public Conexion(){
            enumData data = new enumData();
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection(data.getUrl(), data.getUsusario(), data.getPass());
             System.err.println("Conexion exitosa");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MySQL");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error en la conexion");
            e.printStackTrace();
        }
       }

    public Connection getConexion() {
        return conexion;
    }
    
    public boolean addTotableUsers(String nickname,String password,javax.swing.JLabel Label){
        String sql = "INSERT INTO usuarios (Nickname, Password, Permisos) VALUES (?, ?, 0)";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            String sqlCount = "SELECT COUNT(*) FROM usuarios WHERE Nickname = ?";
            try (PreparedStatement psCount = conexion.prepareStatement(sqlCount)) {
                psCount.setString(1, nickname);
                ResultSet rsCount = psCount.executeQuery();

            if (rsCount.next()) {
            int count = rsCount.getInt(1);
            if(count == 1){
                Label.setText("Cuenta con el mismo usuario ya existe");
                Label.setForeground(Color.RED);
                return false;
            }else{
                ps.setString(1, nickname);
                ps.setString(2, password);
                ps.executeUpdate();
                Label.setText("Cuenta creada con exito");
                Label.setForeground(Color.GREEN);
                return true;
            } 
        }
    }       catch (SQLException e) {
                System.out.println("Error al contar duplicados");
                e.printStackTrace();
    }
            
        }catch (SQLException e){
            System.out.println("Error al introducir datos");
            e.printStackTrace();
        }
        return false;
    }
    
    public void addTotableNodos(String Nombre){
        String sql = "INSERT INTO nodos (Nombre) VALUES (?)";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            String sqlCount = "SELECT COUNT(*) FROM nodos WHERE Nombre = ?";
            try (PreparedStatement psCount = conexion.prepareStatement(sqlCount)) {
                psCount.setString(1, Nombre);
                ResultSet rsCount = psCount.executeQuery();

            if (rsCount.next()) {
            int count = rsCount.getInt(1);
            if(count == 1){
                System.out.println("Nodo ya existente");
            }else{
                ps.setString(1, Nombre);
                int filas = ps.executeUpdate();
                System.out.println("Filas insertadas: " + filas);
            }
        }
    }       catch (SQLException e) {
                System.out.println("Error al contar duplicados");
                e.printStackTrace();
    }
            
        }catch (SQLException e){
            System.out.println("Error al introducir datos");
            e.printStackTrace();
        }  
    }
    public void ImprimirNodos() {
    String sql = "SELECT idNodo, Nombre  FROM nodos";

    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (!rs.next()) {
            System.out.println("No se encontrado nodos.");
        } else {
            do {
                String idNodo = rs.getString("idNodo");
                String Nombre = rs.getString("Nombre");

                System.out.println("Id: " + idNodo + ", Nombre: " + Nombre);
            } while (rs.next());
        }

    } catch (SQLException e) {
        System.out.println("Error al leer la tabla");
        e.printStackTrace();
        }
    }    
    public void imprimirUsuarios() {
    String sql = "SELECT Nickname, Password FROM usuarios";

    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (!rs.next()) {
            System.out.println("No se encontraron usuarios.");
        } else {
            do {
                String nickname = rs.getString("nickname");
                String password = rs.getString("password");

                System.out.println("Nickname: " + nickname + ", Password: " + password);
            } while (rs.next());
        }

    } catch (SQLException e) {
        System.out.println("Error al leer la tabla");
        e.printStackTrace();
        }
    }
    
    public void restartAI(String nTable){
        if (!nTable.matches("[a-zA-Z0-9_]+")) {
            throw new IllegalArgumentException("Invalid table name: " + nTable);
        }

        String sql = "ALTER TABLE " + nTable + " AUTO_INCREMENT = 0";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error al actulizar la tabla");
            e.printStackTrace();
        }
    }
    public void addtoTableArist(int idNodoINI, int idNodoFIN,int ponderado,boolean stairs){
        String sql = "INSERT INTO aristas (idNodoA, idNodoB, Ponderado, Stairs) VALUES (?, ?, ?, ?)";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            
            ps.setInt(1, idNodoINI);
            ps.setInt(2, idNodoFIN);
            ps.setInt(3, ponderado);
            ps.setBoolean(4, stairs);
            
            String sql2 = "SELECT COUNT(*) FROM aristas WHERE idNodoA = ? AND idNodoB = ? AND Ponderado = ? AND Stairs = ?";
            try(PreparedStatement ps1 = conexion.prepareStatement(sql2)){
                ps1.setInt(1, idNodoINI);
                ps1.setInt(2, idNodoFIN);
                ps1.setInt(3, ponderado);
                ps1.setBoolean(4, stairs);
                ResultSet rsCount = ps1.executeQuery();
                int count = 0;
                if(rsCount.next()){
                    count = rsCount.getInt(1);
                }
                if(count > 0){
                    System.out.println("Arista ya existe");
                }
                else{
                    ps.executeUpdate();
                    System.out.println("Arista Agregada");
                }
                
                
            }catch(SQLException e){
                System.out.println("Error al buscar en la table si ya existe la arista");
                e.printStackTrace();
            }
            
            
            
        }catch(SQLException e){
            System.out.println("Error al insentar en la tabla");
            e.printStackTrace();
        }
        
    }
    public void imprimirAristas() {
    String sql = "SELECT Nickname, Password FROM usuarios";

    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (!rs.next()) {
            System.out.println("No se encontraron usuarios.");
        } else {
            do {
                String nickname = rs.getString("nickname");
                String password = rs.getString("password");

                System.out.println("Nickname: " + nickname + ", Password: " + password);
            } while (rs.next());
        }

    } catch (SQLException e) {
        System.out.println("Error al leer la tabla");
        e.printStackTrace();
        }
    }
    public boolean searchUser(String nickname, String passw, JLabel Text){
        String sql = "SELECT * FROM usuarios WHERE  Nickname = ?";
        String user = "";
        String pass = "";
        Boolean perm = false;
        try(PreparedStatement ps =  conexion.prepareStatement(sql)){
            ps.setString(1, nickname);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    user = rs.getString("Nickname");
                    pass = rs.getString("Password");
                    perm = rs.getBoolean("Permisos");
                }
                else{
                    Text.setText("No hay un usuario existente");
                    return false;
                }
                if(pass.equals(passw)){
                    return true;
                }
            }
        }catch(SQLException e){
            System.out.println("Error al obtener el id del nodo");
            e.printStackTrace();
        }
        
        return false;
    }
    public boolean verificarPermisos(String nickname, String passw){
        String sql = "SELECT * FROM usuarios WHERE Nickname = ? AND Password = ?";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, nickname);
            ps.setString(2, passw);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return rs.getBoolean("Permisos");
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public Nodo searchNodo(int id){
        String sql = "SELECT * FROM nodos WHERE idNodo = ?";
        Nodo nodo = null;
        try(PreparedStatement ps =  conexion.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    int id1 = rs.getInt("idNodo");
                    String nombre = rs.getString("Nombre");
                    int s = rs.getInt("idSiguiente");
                    nodo = new Nodo(id1,nombre,searchNodo(s));        
                }
            }
        }catch(SQLException e){
            System.out.println("Error al obtener el id del nodo");
            e.printStackTrace();
        }
        return nodo;
    }
    public Nodo searchNodoName(String nombre){
        String sql = "SELECT * FROM nodos WHERE Nombre = ?";
        Nodo nodo = null;
        try(PreparedStatement ps =  conexion.prepareStatement(sql)){
            ps.setString(1,nombre);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    int id1 = rs.getInt("idNodo");
                    String nombre1 = rs.getString("Nombre");
                    int s = rs.getInt("idSiguiente");
                    nodo = new Nodo(id1,nombre,searchNodo(s));        
                }
            }
        }catch(SQLException e){
            System.out.println("Error al obtener el id del nodo");
            e.printStackTrace();
        }
        return nodo;
    }
    public ListaEnlazada getNodos(){
        String sql = "SELECT Nombre FROM nodos";
        ListaEnlazada ret = new ListaEnlazada();
        try(PreparedStatement ps = conexion.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                return ret;
            }
            else{
                do{
                ret.agregarNodo2(new Nodo(rs.getString("Nombre")));
                }while(rs.next());
            }
            return ret;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ret;
    }
}

