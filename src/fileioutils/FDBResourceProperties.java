/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author alexander
 */
public class FDBResourceProperties implements FIDB<Properties, Properties> {

    private static FDBResourceProperties resourceImage;
    
    private FDBResourceProperties() {
        
    }
    
    public static FDBResourceProperties getInstance() {
        if (resourceImage == null) {
            resourceImage = new FDBResourceProperties();
        }
        
        return resourceImage;
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
            Logger.getLogger(FDBResourceProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void write(String path, Properties info) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
