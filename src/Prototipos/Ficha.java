/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototipos;

import javax.swing.JButton;

/**
 *
 * @author JEASS
 */
public class Ficha extends JButton implements IPrototipo{

    private String nombre;
    private int pX;
    private int pY;
    private String url;
    private int equipo;

    public Ficha(){
        
    }
    
    public Ficha(String nombre, int pX, int pY, String url, int equipo) {
        this.nombre = nombre;
        this.pX = pX;
        this.pY = pY;
        this.equipo = equipo;
        this.url=url;
    }
    
    @Override
    public Object clonar() {
        Ficha clon = new Ficha(nombre, pX, pY, url, equipo);
        return clon;
    }

    public String getUrl() {
        return url;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public int getpX() {
        return pX;
    }

    public void setpX(int pX) {
        this.pX = pX;
    }

    public int getpY() {
        return pY;
    }

    public void setpY(int pY) {
        this.pY = pY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
