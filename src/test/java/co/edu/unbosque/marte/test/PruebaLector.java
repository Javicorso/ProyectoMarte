/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.marte.test;

import co.edu.unbosque.swii.marte.negocio.Tablero;
import co.edu.unbosque.swii.marte.negocio.Archivo;
import co.edu.unbosque.swii.marte.negocio.Reglas;
import co.edu.unbosque.swii.marte.negocio.Robot;
import co.edu.unbosque.swii.marte.util.Lector;
import java.io.FileNotFoundException;
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
    public void laPrimeraLineaEstaCorrecta() throws IOException {
        Archivo a = Archivo.getInstance();
        String linea = a.getLinea().get(0);
        String esperada = "5 5";
        Assert.assertEquals(linea, esperada);
    }

    @Test
    public void esPosibleInstanciarUnTablero() {
        Tablero tesperado = Tablero.getInstance(5, 5);
        Archivo a = Archivo.getInstance();
        Tablero x = a.getTablero();
        Assert.assertEquals(x, tesperado);
    }

    @Test
    public void validaPosicionInicial() throws IOException, NumberFormatException {
        Archivo a = Archivo.getInstance();
        Robot esperado = new Robot();
        esperado.setX(1);
        esperado.setY(4);
        esperado.setOrientacion('N');
        esperado.setMovs("");
        Robot r = a.getRobot(1);
        Assert.assertEquals(r, esperado);
    }

    @Test
    public void validaMovimientos() throws IOException {
        Archivo a = Archivo.getInstance();
        String movsEsperados = "IAIAIAIAAD";
        Robot esperado = a.getRobot(1);
        esperado.setMovs(movsEsperados);
        Robot r = a.getRobotMovs(esperado, 2);
        Assert.assertEquals(r, esperado);
    }

//    @Test
//    public void cambiaOrientacion() throws IOException {
//        Archivo a = Archivo.getInstance();
//        ArrayList<String> lineas = a.getLinea();
//        Pattern pat = Pattern.compile("(I|D|A)+");
//        Matcher mat = pat.matcher(lineas.get(2));
//        if (!mat.matches()) {
//            throw new IOException("Los movimientos no están correctos");
//        }
//        Robot robot = Reglas.iniciarRobot(lineas.get(1));
//        char[] charMov = lineas.get(2).toCharArray();
//        for (int i = 0; i < charMov.length; i++) {
//            switch (charMov[i]) {
//                case 'I':
//                    switch (robot.getOrientacion()) {
//                        case 'N':
//                            robot.setOrientacion('O');
//                            break;
//                        case 'O':
//                            robot.setOrientacion('S');
//                            break;
//                        case 'S':
//                            robot.setOrientacion('E');
//                            break;
//                        case 'E':
//                            robot.setOrientacion('N');
//                            break;
//                        default:
//                            throw new IOException("Orientación no válida");
//                    }
//                    break;
//                case 'D':
//                    switch (robot.getOrientacion()) {
//                        case 'N':
//                            robot.setOrientacion('E');
//                            break;
//                        case 'E':
//                            robot.setOrientacion('S');
//                            break;
//                        case 'S':
//                            robot.setOrientacion('O');
//                            break;
//                        case 'O':
//                            robot.setOrientacion('N');
//                            break;
//                        default:
//                            throw new IOException("Orientación no válida");
//                    }
//                    break;
//                case 'A':
//                    switch (robot.getOrientacion()) {
//                        case 'N':
//                            robot.setOrientacion('O');
//                            break;
//                        case 'O':
//                            robot.setOrientacion('S');
//                            break;
//                        case 'S':
//                            robot.setOrientacion('E');
//                            break;
//                        case 'E':
//                            robot.setOrientacion('N');
//                            break;
//                        default:
//                            throw new IOException("Orientación no válida");
//                    }
//                    break;
//                default:
//                    throw new IOException("Movimiento no permitido");
//            }
//        }
//
//    }

}
