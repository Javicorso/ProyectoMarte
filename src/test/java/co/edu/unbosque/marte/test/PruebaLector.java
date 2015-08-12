/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.marte.test;

import co.edu.unbosque.swii.marte.util.Lector;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;


/**
 *
 * @author clave-e205
 */
public class PruebaLector {

    @Test(expectedExceptions = FileNotFoundException.class)
    public void elArchivoNoDebeExistir() throws FileNotFoundException, IOException {
        Lector x = new Lector();
        x.setArchivo("D:\\HuberPC\\Proyectos\\Marte\\tabler.txt");
    }

    @Test
    public void elArchivoDebeExistir() throws FileNotFoundException, IOException {
        Lector x = new Lector();
        x.setArchivo("D:\\HuberPC\\Proyectos\\Marte\\tablero.txt");
    }

}
