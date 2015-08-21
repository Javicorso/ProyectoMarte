/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.control;

import co.edu.unbosque.swii.marte.negocio.Archivo;
import co.edu.unbosque.swii.marte.negocio.Reglas;
import co.edu.unbosque.swii.marte.negocio.Robot;
import co.edu.unbosque.swii.marte.gui.TableroGUI;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Huber
 */
public class Control {

    private static final Archivo archivo = Archivo.getInstance();

    public static Robot moverRobot(String movs, int i, Robot r) throws IOException {
        switch (i % 2) {
            case 1:
                Robot newRobot = archivo.getRobot(i);
                return newRobot;
            case 0:
                Robot robot = Reglas.moverRobot(r, movs);
                return robot;
        }
        return null;
    }

}
