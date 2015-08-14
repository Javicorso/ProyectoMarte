/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.marte.test;

import co.edu.unbosque.swii.marte.negocio.Archivo;
import co.edu.unbosque.swii.marte.negocio.Reglas;
import co.edu.unbosque.swii.marte.negocio.Robot;
import co.edu.unbosque.swii.marte.util.Lector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author clave-e205
 */
public class PruebaLector {

    @Test(expectedExceptions = FileNotFoundException.class)
    public void elArchivoNoDebeExistir() throws FileNotFoundException, IOException {
        Lector x = new Lector();
        x.setArchivo("tabler.txt");
    }

    @Test
    public void elArchivoDebeExistir() throws FileNotFoundException, IOException {
        Lector x = new Lector();
        x.setArchivo("src/main/resources/tablero.txt");
    }

    @Test
    public void elArchivoNoEstaVacio() throws IOException {
        File f = new File("src/main/resources/tablero.txt");
        int cont = 0;
        FileReader file = new FileReader(f);
        BufferedReader br = new BufferedReader(file);
        String linea;
        Archivo archivo = Archivo.getInstance();
        while ((linea = br.readLine()) != null) {
            cont++;
            archivo.getLinea().add(linea);
        }
        if (cont == 0) {
            throw new IOException("El archivo está vacío");
        }
    }

    @Test
    public void laPrimeraLineaEstaCorrecta() throws IOException {
        File f = new File("src/main/resources/tablero.txt");
        FileReader file = new FileReader(f);
        BufferedReader br = new BufferedReader(file);
        String linea;
        String esperada = "5 5";
        linea = br.readLine();
        Assert.assertEquals(linea, esperada);
    }

    @Test
    public void laPrimeraLineaSonNumericos() throws NumberFormatException, IOException {
        Lector lector = new Lector();
        Archivo a = lector.setArchivo("src/main/resources/tablero.txt");
        ArrayList<String> lineas = a.getLinea();
        String linea = lineas.get(0);
        String[] l = linea.split(" ");
        int x = Integer.valueOf(l[0]);
        int y = Integer.valueOf(l[1]);

    }

    @Test
    public void validarCoordenadas() throws IOException {
        Lector lector = new Lector();
        Archivo a = lector.setArchivo("src/main/resources/tablero.txt");
        ArrayList<String> lineas = a.getLinea();
        String linea = lineas.get(0);
        String[] l = linea.split(" ");
        if (l.length != 2) {
            throw new IOException("EL formato de coordendas es incorrecto");
        }
    }

    @Test
    public void validaPosicionInicial() throws IOException, NumberFormatException {
        Lector lector = new Lector();
        Archivo a = lector.setArchivo("src/main/resources/tablero.txt");
        ArrayList<String> lineas = a.getLinea();
        String linea = lineas.get(1);
        String[] l = linea.split(" ");
        if (l.length != 3) {
            throw new IOException("La posición inicial es incorrecta");
        }
        int x = Integer.valueOf(l[0]);
        int y = Integer.valueOf(l[1]);
        char p = l[2].charAt(0);
    }

    @Test
    public void validaMovimientos() throws IOException, NumberFormatException {
        Lector lector = new Lector();
        Archivo a = lector.setArchivo("src/main/resources/tablero.txt");
        ArrayList<String> lineas = a.getLinea();
        Pattern pat = Pattern.compile("(I|D|A)+");
        Matcher mat = pat.matcher(lineas.get(2));
        if (!mat.matches()) {
            throw new IOException("Los movimientos no están correctos");
        }
    }

    @Test
    public void cambiaOrientacion() throws IOException {
        Lector lector = new Lector();
        Archivo a = lector.setArchivo("src/main/resources/tablero.txt");
        ArrayList<String> lineas = a.getLinea();
        Pattern pat = Pattern.compile("(I|D|A)+");
        Matcher mat = pat.matcher(lineas.get(2));
        if (!mat.matches()) {
            throw new IOException("Los movimientos no están correctos");
        }
        Robot robot = Reglas.iniciarRobot(lineas.get(1));
        char[] charMov = lineas.get(2).toCharArray();
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

    }

}
