/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses.interfaces;

import java.io.IOException;

/**
 * Estructura general que debe tener una clase que se encargue de la entrada y
 * salida de datos en un archivo.
 * @author aborbon
 * @param <T> Al leer del archivo se debe devolver la información de este tipo.
 * @param <Q> Cuando se guarda en el archivo, la información que se guarda debe ser de este tipo.
 */
public interface FIOI<T, Q> {
    
    /**
     * Realiza la lectura de un archivo.
     * @param path Dirección del archivo del cual se quiere leer.
     * @return La información que se leyó del archivo.
     * @throws IOException Excepción si no pudo leer la información del archivo.
     */
    public T read(String path) throws IOException;
    
    /**
     * Realiza la escritura a un archivo.
     * @param path Dirección del archivo del cual se quiere escribir.
     * @param info Información que se quiere guardar en el archivo.
     * @throws IOException Excepción si no pudo guardar correctamente en el archivo.
     */
    public void write(String path, Q info) throws IOException;
}
