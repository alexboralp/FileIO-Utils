/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 * Clase de utilidades varias para el manejo de entrada y salida de archivos.
 * @author aborbon
 */
public class FIOUtils {
    
    /**
     * Determina el folder actual en el que está corriendo el programa.
     * @return La dirección del folder actual del programa.
     */
    public static String getCurrentFolder() {
        return System.getProperty("user.dir");
    }
    
    /**
     * Obtiene los nombres de todo el contenido de un folder.
     * @param path Dirección del folder de donde se quiere obtener el contenido.
     * @return Un arreglo de String con el contenido del folder dado.
     */
    public static String[] getFolderContent(String path) {
        return new File(path).list();
    }
    
    /**
     * Carga un archivo de imagen y le aplica un factor de escala.
     * @param path Dirección del archivo de imagen que se quiere cargar.
     * @param scale El factor por el cual se quiere escalar la imagen.
     * @return Un ImageIcon con la imagen escalada.
     * @throws IOException Excepción si no se pudo cargar la imagen correctamente.
     */
    public static ImageIcon ImageIconLoadAndScale(String path, double scale) throws IOException {
        ImageIcon imageIcon = (ImageIcon)FIOFact.create(path).read(path);
        int nw = (int)(imageIcon.getIconWidth() * scale);
        int nh = (int)(imageIcon.getIconHeight() * scale);
        return new ImageIcon(imageIcon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }
    
    /**
     * Abre un archivo en la dirección dada.
     * @param path Dirección con el nombre del archivo que se quiere abrir.
     * @return Un BufferedWriter del archivo que se abre.
     * @throws IOException Excepción si no se pudo abrir correctamente el archivo.
     */
    public static BufferedWriter openFile(String path) throws IOException {
        return new BufferedWriter(new FileWriter(path, true));
    }
    
    /**
     * Agrega una nueva línea de texto a un archivo abierto.
     * @param writer Un BufferedWriter que apunta al archivo en el que se quiere guardar el texto.
     * @param message La línea de texto que se quiere guardar en el archivo.
     * @throws IOException Excepción si no se pudo agregar el texto al archivo.
     */
    public static void appendToFile(BufferedWriter writer, String message) throws IOException {
        writer.newLine();       // Agrega una nuea línea al archivo
        writer.write(message);  // Agrega el texto al archivo
        writer.flush();         // Solicita que se escriba el texto en el disco duro
    }
    
    /**
     * Cierra un archivo que se abrió anteriormente.
     * @param writer El BufferedWriter que apunta al archivo que se quiere cerrar.
     * @throws IOException Excepción si no se pudo cerrar el archivo deseado.
     */
    public static void closeFile(BufferedWriter writer) throws IOException {
        writer.close();
    }
}
