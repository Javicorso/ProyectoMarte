/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.gui;

import co.edu.unbosque.swii.marte.negocio.Archivo;
import co.edu.unbosque.swii.marte.util.Lector;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author Huber
 */
public class VentanaExplorador extends JFrame implements ActionListener {

    private Container contenedor;
    JButton leerArchivo;
    JButton iniciarExplorador;
    JLabel labelTitulo;
    JTextArea area;
    JScrollPane scroll;
    private VentanaExplorador ventana;

    public VentanaExplorador() {
        iniciarComponentes();
        setTitle("Iniciar viaje a Marte");
        setSize(355, 300);
        setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        }
        );
    }

    public void setVentanaPrincipal(VentanaExplorador ventana) {
        this.ventana = ventana;
    }

    private void iniciarComponentes() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        leerArchivo = new JButton();
        leerArchivo.setText("Leer archivo");
        leerArchivo.setBounds(90, 80, 150, 23);
        leerArchivo.addActionListener(this);

        iniciarExplorador = new JButton();
        iniciarExplorador.setText("Explorar");
        iniciarExplorador.setBounds(90, 230, 150, 23);
        iniciarExplorador.addActionListener(this);
        iniciarExplorador.setVisible(false);

        labelTitulo = new JLabel("Cargar archivo de coordenadas");
        labelTitulo.setBounds(10, 20, 300, 30);

        area = new JTextArea();
        area.setBounds(100, 100, 100, 100);

        scroll = new JScrollPane(area);
        scroll.setBounds(20, 120, 300, 100);

        contenedor.add(labelTitulo);
        contenedor.add(leerArchivo);
        contenedor.add(scroll);
        contenedor.add(iniciarExplorador);

        scroll.setVisible(true);
        scroll.setViewportView(area);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == leerArchivo) {
            try {
                Archivo a = Lector.setArchivo("src/main/resources/tablero.txt");
                String text = "Ruta del archivo: src/main/resources/tablero.txt \n";
                area.setText(text);
                text = text + "Dimensión de Tablero: X=" + a.getTablero().getX() + " Y=" + a.getTablero().getY() + "\n";
                area.setText(text);
                ArrayList<String> lineas = a.getLinea();
                for (int i = 1; i < lineas.size(); i++) {
                    if (i % 2 == 1) {
                        text = text + "Robot " + i + ":" + lineas.get(i);
                        area.setText(text);
                    } else {
                        text = text + " -- Movimientos :" + lineas.get(i) + "\n";
                        area.setText(text);
                    }
                }
                leerArchivo.setVisible(false);
                iniciarExplorador.setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(VentanaExplorador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (evento.getSource() == iniciarExplorador) {
            new TableroMarte();
        }
    }
}
