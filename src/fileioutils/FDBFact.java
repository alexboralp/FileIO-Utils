/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
import fileioutils.FDBFact.DB_TYPE;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import utils.Logger;

/**
 *
 * @author alexander
 */
public class FDBFact implements FIFact<FIDB, DB_TYPE> {
    
    public static enum DB_TYPE {
        DBTxt,
        DBProperties,
        DBBinary,
        DBImageIcon,
        DBJson,
        DBResourceImageIcon,
        DBResourceProperties,
        DBResourceTxt
    }
    
    private static FDBFact dbFactory;
    
    private FDBFact() {}

    public static FDBFact getIntance() {
        if (dbFactory == null) {
            dbFactory = new FDBFact();
        }
        
        return dbFactory;
    }

    @Override
    public FIDB create() {
        return FDBTxt.getInstance();
    }

    @Override
    public FIDB create(DB_TYPE type) {
        
        switch (type) {
            case DBTxt:
                return FDBTxt.getInstance();
            case DBProperties:
                return FDBProperties.getInstance();
            case DBBinary:
                return FDBBinary.getInstance();
            case DBImageIcon:
                return FDBImageIcon.getInstance();
            case DBJson:
                return FDBJson.getInstance();
            case DBResourceImageIcon:
                return FDBResourceImageIcon.getInstance();
            case DBResourceProperties:
                return FDBResourceProperties.getInstance();
            case DBResourceTxt:
                return FDBResourceTxt.getInstance();
        }
        
        return null;
    }

    public FIDB create(String className) {
        try {
            return (FIDB)Class.forName("fileioutils." + className.toLowerCase()).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(FDBFact.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
