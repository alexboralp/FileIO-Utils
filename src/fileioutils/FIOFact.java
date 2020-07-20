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
 *
 * @author alexander
 */
public class FIOFact {
    
    public static enum FIO_TYPE {
        Path,
        Resource
    }
    
    public static FIOI create(String ext) {
        return FIOFact.create(FIO_TYPE.Path, ext);
    }
    
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

    public static FIOI create_class(String className) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        Class<?> cls = Class.forName("fileioutils.ioclasses." + className);
        Method m = cls.getMethod("getInstance");
        return (FIOI) m.invoke(null);
    }
    
}
