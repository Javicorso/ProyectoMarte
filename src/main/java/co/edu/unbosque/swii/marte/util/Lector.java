/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.util;

import co.edu.unbosque.swii.marte.negocio.Archivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author clave-e205
 */
public class Lector {

    public static Archivo setArchivo(String url) throws FileNotFoundException, IOException {
        File f = new File(url);
        Archivo archivo = Archivo.getInstance();
        if (!f.exists()) {
            throw new FileNotFoundException();
        } else {
            int cont = 0;
            FileReader file = new FileReader(f);
            BufferedReader br = new BufferedReader(file);
            String linea;
            while ((linea = br.readLine()) != null) {
                cont++;
                archivo.getLinea().add(linea);
            }
            if (cont == 0) {
                throw new IOException("El archivo está vacío");
            }
        }
        return archivo;
    }
}
