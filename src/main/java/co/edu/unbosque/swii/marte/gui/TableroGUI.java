/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.gui;

import co.edu.unbosque.swii.marte.control.Control;
import co.edu.unbosque.swii.marte.negocio.Archivo;
import co.edu.unbosque.swii.marte.negocio.Reglas;
import co.edu.unbosque.swii.marte.negocio.Robot;
import co.edu.unbosque.swii.marte.negocio.Tablero;
import co.edu.unbosque.swii.marte.util.ColorEnum;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.*;
import java.util.ArrayList;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author Huber
 */
public class TableroGUI {

    private static TableroGUI instance;
    private final JPanel tableroJP;
    private final JPanel[][] casillasJP;
    private static Robot robot;
    int x;
    int y;

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

    private TableroGUI(JFrame f, Tablero t) {
        this.x = t.getX();
        this.y = t.getY();
        casillasJP = new JPanel[x][y + 1];
        Container c = f.getContentPane();
        tableroJP = new JPanel();
        c.add(tableroJP, "Center");
    }

    public static TableroGUI getInstace(JFrame f, Tablero t) {
        if (instance == null) {
            instance = new TableroGUI(f, t);
        }
        return instance;
    }

    public void crearTablero() throws IOException {

        tableroJP.add(new Labels(" "));
        LabelHorizontal();

        tableroJP.setLayout(new GridLayout(y + 1, x));
        for (int i = 0; i < y; i++) {
            tableroJP.add(new Labels((new Integer(i)).toString()));
            for (int j = 0; j < x; j++) {
                JPanel jp = new JPanel();
                jp.setLayout(new BorderLayout());
                jp.setBorder(BorderFactory.createLineBorder(Color.black));
                jp.setPreferredSize(new Dimension(50, 50));
                casillasJP[j][i] = jp;
                tableroJP.add(casillasJP[j][i]);
            }
        }

    }

    public void explorarTablero() throws IOException, InterruptedException {

        ArrayList<String> lineas = Archivo.getInstance().getLinea();

        for (int i = 1; i < lineas.size(); i++) {
            JPanel jp = new JPanel();
            jp.setLayout(new BorderLayout());
            jp.setBorder(BorderFactory.createLineBorder(Color.black));
            jp.setPreferredSize(new Dimension(50, 50));
            jp.setBackground(Color.getColor("WHITE"));
            JLabel orientacion = new JLabel("*");
            orientacion.setHorizontalAlignment(SwingConstants.CENTER);
            robot = (Control.moverRobot(lineas.get(i), i, robot));
            switch (robot.getOrientacion()) {
                case 'N':
                    jp.add(orientacion, BorderLayout.NORTH);
                    break;
                case 'O':
                    jp.add(orientacion, BorderLayout.WEST);
                    break;
                case 'S':
                    jp.add(orientacion, BorderLayout.SOUTH);
                    break;
                case 'E':
                    jp.add(orientacion, BorderLayout.EAST);
                    break;
                default:
                    throw new IOException("Orientación no válida");
            }
            casillasJP[robot.getY()][robot.getX()] = jp;
            //tableroJP.add(casillasJP[robot.getY()][robot.getX()]);
            System.out.println("Coord: " + robot.getX() +" "+ robot.getY());
        }
    }

    private void LabelHorizontal() {
        for (int j = 0; j < x; j++) {
            JPanel jp = new JPanel();
            jp.setPreferredSize(new Dimension(50, 50));
            jp.add(new Labels((new Integer(j)).toString()));
            casillasJP[j][y] = jp;
            tableroJP.add(casillasJP[j][y]);
        }
    }

    class Labels extends JLabel {

        Labels(String s) {
            super(s);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }
    }

}
