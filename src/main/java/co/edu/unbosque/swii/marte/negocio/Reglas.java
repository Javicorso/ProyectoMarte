/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.negocio;

import co.edu.unbosque.swii.marte.gui.TableroGUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;

/**
 *
 * @author Huber
 */
public class Reglas {

    public static TableroGUI iniciarTablero(Archivo archivo, JFrame f){
        ArrayList<String> lineas = archivo.getLinea();
        String linea = lineas.get(0);
        String[] l = linea.split(" ");
        TableroGUI t;
        t = TableroGUI.getInstace(f, Integer.valueOf(l[0]), Integer.valueOf(l[1]));
        return t;
    }

    public static Robot iniciarRobot(String posicion) throws IOException, NumberFormatException {
        Robot robot = new Robot();
        String[] l = posicion.split(" ");
        if (l.length != 3) {
            throw new IOException("La posición inicial es incorrecta");
        }
        int x = Integer.valueOf(l[0]);
        int y = Integer.valueOf(l[1]);
        char p = l[2].charAt(0);
        robot.setX(x);
        robot.setY(y);
        robot.setOrientacion(p);
        return robot;
    }

    public static Robot moverRobot(Robot robot, String movimientos) throws IOException {
        Pattern pat = Pattern.compile("(I|D|A)+");
        Matcher mat = pat.matcher(movimientos);
        if (!mat.matches()) {
            throw new IOException("Los movimientos no están correctos");
        }
        char[] charMov = movimientos.toCharArray();
        for (int i = 0; i < charMov.length; i++) {
            switch (charMov[i]) {
                case 'I':
                    switch (robot.getOrientacion()) {
                        case 'N':
                            robot.setOrientacion('O');
                            break;
                        case 'O':
                            robot.setOrientacion('S');
                            break;
                        case 'S':
                            robot.setOrientacion('E');
                            break;
                        case 'E':
                            robot.setOrientacion('N');
                            break;
                        default:
                            throw new IOException("Orientación no válida");
                    }
                    break;
                case 'D':
                    switch (robot.getOrientacion()) {
                        case 'N':
                            robot.setOrientacion('E');
                            break;
                        case 'E':
                            robot.setOrientacion('S');
                            break;
                        case 'S':
                            robot.setOrientacion('O');
                            break;
                        case 'O':
                            robot.setOrientacion('N');
                            break;
                        default:
                            throw new IOException("Orientación no válida");
                    }
                    break;
                case 'A':
                    switch (robot.getOrientacion()) {
                        case 'N':
                            robot.setOrientacion('O');
                            break;
                        case 'O':
                            robot.setOrientacion('S');
                            break;
                        case 'S':
                            robot.setOrientacion('E');
                            break;
                        case 'E':
                            robot.setOrientacion('N');
                            break;
                        default:
                            throw new IOException("Orientación no válida");
                    }
                    break;
                default:
                    throw new IOException("Movimiento no permitido");
            }
        }

        return robot;
    }

}
