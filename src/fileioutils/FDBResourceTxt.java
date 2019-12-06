/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author alexander
 */
public class FDBResourceTxt implements FIDB<String, String> {

    private static FDBResourceTxt resourceImage;
    
    private FDBResourceTxt() {
        
    }
    
    public static FDBResourceTxt getInstance() {
        if (resourceImage == null) {
            resourceImage = new FDBResourceTxt();
        }
        
        return resourceImage;
    }
    
    @Override
    public String read(String resourcePath) {
        try {
            InputStream in = getClass().getResourceAsStream(resourcePath);
            return new String(in.readAllBytes());
        } catch (IOException ex) {
            Logger.getLogger(FDBResourceTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void write(String path, String info) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
