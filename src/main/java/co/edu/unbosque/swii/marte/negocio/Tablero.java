/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.negocio;

/**
 *
 * @author clave-e205
 */
public class Tablero {

    public static Tablero instance;
    private int x;
    private int y;

    private Tablero(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Tablero getInstance(int x, int y) {
        if (instance == null) {
            instance = new Tablero(x, y);
        }
        return instance;    
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Tablero)) {
            return false;
        }
        Tablero tmp = (Tablero) obj;
        return (this.x == tmp.x && this.y == tmp.y);
    }

}
