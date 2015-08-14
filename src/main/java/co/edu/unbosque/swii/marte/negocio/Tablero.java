/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.negocio;

import javax.swing.*;
import java.awt.*;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author Huber
 */
public class Tablero {

    private static Tablero instance;
    private final JPanel tableroJP;
    private final JPanel[][] casillasJP;
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

    private Tablero(JFrame f, int x, int y) {
        this.x = x;
        this.y = y;
        casillasJP = new JPanel[x][y + 1];
        Container c = f.getContentPane();
        tableroJP = new JPanel();
        c.add(tableroJP, "Center");
    }

    public static Tablero getInstace(JFrame f, int x, int y) {
        if (instance == null) {
            instance = new Tablero(f, x, y);
        }
        return instance;
    }

    public void crearTableroGUI() {

        tableroJP.add(new BLabel(" "));
        filaLetras();

        tableroJP.setLayout(new GridLayout(y + 1, x));
        for (int i = 0; i < y; i++) {
            tableroJP.add(new BLabel((new Integer(i)).toString()));
            for (int j = 0; j < x; j++) {
                JPanel jp = new JPanel();
                jp.setBorder(BorderFactory.createLineBorder(Color.black));
                if (j == 3 && i == 4) {
                    jp.setBackground(Color.yellow);
                    JLabel orientacion = new JLabel("*");
                    orientacion.setVerticalAlignment(SwingConstants.CENTER);
                    jp.add(orientacion);
                }
                jp.setPreferredSize(new Dimension(50, 50));
                casillasJP[j][i] = jp;

                tableroJP.add(casillasJP[j][i]);
            }
        }

    }

    private void filaLetras() {
        for (int j = 0; j < x; j++) {
            JPanel jp = new JPanel();
            jp.setPreferredSize(new Dimension(50, 50));
            jp.add(new BLabel((new Integer(j)).toString()));
            casillasJP[j][y] = jp;
            tableroJP.add(casillasJP[j][y]);
        }
    }

    class BLabel extends JLabel {

        BLabel(String s) {
            super(s);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }
    }

}
