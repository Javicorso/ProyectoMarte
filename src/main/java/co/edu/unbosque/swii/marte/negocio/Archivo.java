/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.negocio;

import java.util.ArrayList;

/**
 *
 * @author Huber
 */
public class Archivo {

    private static Archivo instance;
    private ArrayList<String> linea;

    private Archivo() {

    }

    public static Archivo getInstance() {
        if (instance == null) {
            instance = new Archivo();
        }
        return instance;
    }

    public ArrayList<String> getLinea() {
        if (linea == null) {
            linea = new ArrayList<>();
        }
        return linea;
    }

    public Tablero getTablero() {
        String lineaTablero=linea.get(0);
        String parts[]=lineaTablero.split(" ");
        int x=Integer.parseInt(parts[0]);
        int y=Integer.parseInt(parts[1]);
        
        return new Tablero(x,y);
    }

    public Robot getRobot() {
        String lineaTablero=linea.get(1);
        String parts[]=lineaTablero.split(" ");
        int x=Integer.parseInt(parts[0]);
        int y=Integer.parseInt(parts[1]);
        char orientacion=parts[2].charAt(0);
        Robot ro=new Robot();
        ro.setX(x);
        ro.setY(y);
        ro.setOrientacion(orientacion);
        return ro;
    }

}
