/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

import fileioutils.FIOFact.FIO_TYPE;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import fileioutils.ioclasses.interfaces.FIOI;
import java.lang.reflect.Method;
//import utils.Logger;

/**
 * Factory para crear un manejador de entrada y salida de archivos
 * @author alexander
 */
public class FIOFact {
    /**
     * Tipo de manejador de entrada y salida de archivos:
     * Path: Se debe dar toda la dirección para guardar el archivo.
     * Resource: Se utiliza la dirección de los recursos del programa.
     */
    public static enum FIO_TYPE {
        Path,
        Resource
    }
    
    /**
     * Método para crear el manejador de entrada y salida de archivos.
     * Por defecto se hace el manejador de tipo Path.
     * @param ext La extensión del archivo con el que se quiere trabajar.
     * @return El manejador de entrada y salida de archivos para la extensión dada.
     */
    public static FIOI create(String ext) {
        return FIOFact.create(FIO_TYPE.Path, ext);
    }
    
    /**
     * Método para crear el manejador de entrada y salida de archivos.
     * @param type Tipo de manejador de entrada y salida de archivos:
     * @param ext La extensión del archivo con el que se quiere trabajar.
     * @return El manejador de entrada y salida de archivos para la extensión dada.
     */
    public static FIOI create(FIO_TYPE type, String ext) {
        
        String className = "FIO_" + type.toString() + "_";
        
        try {
            return create_class(className.concat(ext.toLowerCase()));
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            try {
                return create_class("FIO_" + type.toString() + "_txt");
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex1) {
                Logger.getLogger(FIOFact.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        return null;
    }

    /*
     * Crea la clase que se necesita para el manejador solicitado y la instancia.
     */
    private static FIOI create_class(String className) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        Class<?> cls = Class.forName("fileioutils.ioclasses." + className);
        Method m = cls.getMethod("getInstance");
        return (FIOI) m.invoke(null);
    }
    
}
