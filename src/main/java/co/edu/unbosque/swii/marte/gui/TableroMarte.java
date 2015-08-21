package co.edu.unbosque.swii.marte.gui;

import co.edu.unbosque.swii.marte.negocio.Archivo;
import co.edu.unbosque.swii.marte.negocio.Reglas;
import co.edu.unbosque.swii.marte.negocio.Tablero;
import co.edu.unbosque.swii.marte.util.Lector;
import javax.swing.*;
import java.awt.event.*;

public class TableroMarte extends JFrame {

    TableroGUI tableroGUI;

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
            tableroGUI = TableroGUI.getInstace(this, Archivo.getInstance().getTablero());
            tableroGUI.crearTablero();
            setVisible(true);
            tableroGUI.explorarTablero();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
