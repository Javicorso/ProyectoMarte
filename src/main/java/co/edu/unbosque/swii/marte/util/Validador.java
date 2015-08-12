/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.util;

import java.io.IOException;

/**
 *
 * @author Huber
 */
public class Validador {

    public static void validarLineaInicial(String linea, int pos) throws IOException {
        switch (pos) {
            case 1:
                String[] coord = linea.split(" ");
                if (coord.length != 2) {
                    throw new IOException("La primera línea del archivo debe contener las coordenadas x,y "
                            + "del tamaño del tablero");
                } else {
                    try {
                        int x = Integer.parseInt(coord[0]);
                        int y = Integer.parseInt(coord[1]);
                    } catch (NumberFormatException e) {
                        throw new IOException("Las coordenadas solo pueden ser numéricas");
                    }
                }
        }
    }

}
