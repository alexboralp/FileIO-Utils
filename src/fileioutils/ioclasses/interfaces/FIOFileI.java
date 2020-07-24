/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses.interfaces;

import java.io.IOException;

/**
 * Interface que debe tener una clase que realiza apertura, escritura y cierre
 * de archivos.
 * @author aborbon
 * @param <T> Tipo de dato que se quiere guardar en el archivo.
 */
public interface FIOFileI <T> {
    public void openFile(String path) throws IOException;
    public void appendToFile(T message) throws IOException;
    public void closeFile() throws IOException;
}
