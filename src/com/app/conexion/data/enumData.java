/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.conexion.data;

/**
 *
 * @author bohor
 */
public class enumData {
    private String url;
    private String ususario;
    private String pass;

    public enumData() {
        this.url = "jdbc:mysql://127.0.0.1:3306/datosgrafos";
        this.ususario = "Luky";
        this.pass = "123";
    }

    public String getUrl() {
        return url;
    }

    public String getUsusario() {
        return ususario;
    }


    public String getPass() {
        return pass;
    }

    
    
    
}
