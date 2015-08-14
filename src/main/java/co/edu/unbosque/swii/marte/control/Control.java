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
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Huber
 */
public class Control {

    public Tablero tablero;
    private static Archivo archivo = Archivo.getInstance();
    private ArrayList<Robot> listRobots;


    public void moverRobot() throws IOException {
        ArrayList<String> lineas = archivo.getLinea();
        for (int i = 1; i < lineas.size(); i++) {
            switch (i % 2) {
                case 1:
                    Robot newRobot = Reglas.iniciarRobot(lineas.get(i));
                    listRobots.add(newRobot);
                case 0:
                    Robot robot = Reglas.moverRobot(listRobots.get(i - 1), lineas.get(i));
                    listRobots.set(i-1, robot);
            }
        }
    }

}
