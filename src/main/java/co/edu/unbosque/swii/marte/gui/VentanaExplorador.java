/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Huber
 */
public class VentanaExplorador extends JFrame implements ActionListener {

    private Container contenedor;
    JButton botonCambiar;
    JLabel labelTitulo;
    private VentanaExplorador ventana;

    public VentanaExplorador() {
        iniciarComponentes();
        setTitle("Iniciar viaje a Marte");
        setSize(300, 180);
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

        botonCambiar = new JButton();
        botonCambiar.setText("Leer archivo");
        botonCambiar.setBounds(100, 80, 80, 23);
        botonCambiar.addActionListener(this);

        labelTitulo = new JLabel("Cargar archivo de coordenadas");
        labelTitulo.setBounds(10,20,300,30);

        contenedor.add(labelTitulo);
        contenedor.add(botonCambiar);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == botonCambiar) {
            new TableroMarte();
        }
    }
}
