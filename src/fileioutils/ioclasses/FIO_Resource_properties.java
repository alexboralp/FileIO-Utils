/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import fileioutils.ioclasses.interfaces.FIOI;

/**
 *
 * @author alexander
 */
public class FIO_Resource_properties implements FIOI<Properties, Properties> {

    private static FIO_Resource_properties fioResourceProperties;
    
    private FIO_Resource_properties() {
        
    }
    
    public static FIO_Resource_properties getInstance() {
        if (fioResourceProperties == null) {
            fioResourceProperties = new FIO_Resource_properties();
        }
        
        return fioResourceProperties;
    }
    
    @Override
    public Properties read(String resourcePath) {
        Properties properties;
        try {
            InputStream in = getClass().getResourceAsStream(resourcePath);
            properties = new Properties();
            properties.load(in);
            return properties;
        } catch (IOException ex) {
            Logger.getLogger(FIO_Resource_properties.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void write(String path, Properties info) throws IOException {
        throw new UnsupportedOperationException("You can not write to a Resource file."); //To change body of generated methods, choose Tools | Templates.
    }
}
