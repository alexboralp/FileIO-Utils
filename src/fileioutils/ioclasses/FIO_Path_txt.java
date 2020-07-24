/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import fileioutils.ioclasses.interfaces.FIOI;

/**
 * Clase que se encarga de la lectura y escritura de texto en archivo.
 * @author alexander
 */
public class FIO_Path_txt implements FIOI<String, String> {

    private static FIO_Path_txt fioPathTxt;
    
    private FIO_Path_txt() { }
    
    /**
     * Crea y devuelve una instacia de la clase.
     * @return Una instancia de la clase.
     */
    public static FIO_Path_txt getInstance() {
        if (fioPathTxt == null) {
            fioPathTxt = new FIO_Path_txt();
        }
        
        return fioPathTxt;
    }

    @Override
    public String read(String path) throws IOException {
        return new String ( (byte[])FIO_Binary.getInstance().read(path) );
    }

    @Override
    public void write(String path, String info) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(info);
        }
    }
    
}
