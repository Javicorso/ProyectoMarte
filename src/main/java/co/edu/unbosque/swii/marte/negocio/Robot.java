/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.negocio;

/**
 *
 * @author Huber
 */
public class Robot {
    
    private int x;
    private int y;
    private char orientacion;
    private String movs;
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public char getOrientacion() {
        return orientacion;
    }
    
    public void setOrientacion(char orientacion) {
        this.orientacion = orientacion;
    }
    
    public String getMovs() {
        return movs;
    }
    
    public void setMovs(String movs) {
        this.movs = movs;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Robot)) {
            return false;
        }
        Robot tmp = (Robot) obj;
        return (this.x == tmp.x && this.y == tmp.y && this.orientacion == tmp.orientacion && 
                this.movs.equals(tmp.movs));
    }
    
}
