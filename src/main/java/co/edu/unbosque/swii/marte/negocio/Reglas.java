/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.negocio;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Huber
 */
public class Reglas {

    public static Tablero iniciarTablero(String ini) {
        String parts[] = ini.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        Tablero t = Tablero.getInstance(x, y);
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
        robot.setMovs("");
        return robot;
    }

    public static Robot getRobotMovs(Robot r, String movs) throws IOException {
        Pattern pat = Pattern.compile("(I|D|A)+");
        Matcher mat = pat.matcher(movs);
        if (!mat.matches()) {
            throw new IOException("Los movimientos no están correctos");
        }
        r.setMovs(movs);
        return r;
    }

    public static Robot moverRobot(Robot robot, String movimientos) throws IOException {
        Pattern pat = Pattern.compile("(I|D|A)+");
        Matcher mat = pat.matcher(movimientos);
        if (!mat.matches()) {
            throw new IOException("Los movimientos no están correctos");
        }
        robot.setMovs(movimientos);
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
                            robot.setY(robot.getY()-1);
                            break;
                        case 'O':
                            robot.setX(robot.getX()-1);
                            break;
                        case 'S':
                            robot.setY(robot.getY()+1);
                            break;
                        case 'E':
                            robot.setX(robot.getX()+1);
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
