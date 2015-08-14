/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.control;

import co.edu.unbosque.swii.marte.negocio.Archivo;
import co.edu.unbosque.swii.marte.negocio.Reglas;
import co.edu.unbosque.swii.marte.negocio.Robot;
import co.edu.unbosque.swii.marte.negocio.Tablero;
import co.edu.unbosque.swii.marte.util.Lector;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Huber
 */
public class Control {

    public Tablero tablero;
    private Archivo archivo;
    private ArrayList<Robot> listRobots;

    public void inicio() throws IOException {
        Lector lector = new Lector();
        archivo = lector.setArchivo("src/main/resources/tablero.txt");
        tablero = Reglas.iniciarTablero(archivo);
    }

    public void moverRobot() throws IOException {
        ArrayList<String> lineas = archivo.getLinea();
        for (int i = 1; i < lineas.size(); i++) {
            switch (i % 2) {
                case 1:
                    Robot newRobot = Reglas.iniciarRobot(lineas.get(i));
                    listRobots.add(newRobot);
                case 0:
                    Robot robot = Reglas.moverRobot(listRobots.get(i - 1), lineas.get(i));
                    listRobots.
            }
        }
    }

}
