/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.negocio;

import java.io.IOException;
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
        String lineaTablero = linea.get(0);
        return Reglas.iniciarTablero(lineaTablero);
    }

    public Robot getRobot(int i) throws IOException, NumberFormatException {
        String lineaTablero = linea.get(i);
        Robot ro = Reglas.iniciarRobot(lineaTablero);
        return ro;
    }

    public Robot getRobotMovs(Robot r, int j) throws IOException {
        String lineaTablero = linea.get(j);
        r = Reglas.getRobotMovs(r, lineaTablero);
        return r;
    }

}
