package co.edu.unbosque.swii.marte.gui;

import co.edu.unbosque.swii.marte.negocio.Reglas;
import co.edu.unbosque.swii.marte.util.Lector;
import javax.swing.*;
import java.awt.event.*;

public class TableroMarte extends JFrame {

    TableroGUI tablero;

    public TableroMarte() {

        this.setSize(500, 500);
        this.setTitle("Proyecto Marte");
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        }
        );
        this.setLocationRelativeTo(null);
        try {
            tablero = Reglas.iniciarTablero(Lector.setArchivo("src/main/resources/tablero.txt"), this);
            tablero.crearTablero();
            setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
