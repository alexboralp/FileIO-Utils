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
public class FDBResourceImageIcon implements FIDB<ImageIcon, ImageIcon> {

    private static FDBResourceImageIcon resourceImage;
    
    private FDBResourceImageIcon() {
        
    }
    
    public static FDBResourceImageIcon getInstance() {
        if (resourceImage == null) {
            resourceImage = new FDBResourceImageIcon();
        }
        
        return resourceImage;
    }
    
    @Override
    public ImageIcon read(String resourcePath) {
        try {
            InputStream in = getClass().getResourceAsStream(resourcePath);
            return new ImageIcon(in.readAllBytes());
        } catch (IOException ex) {
            Logger.getLogger(FDBResourceImageIcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void write(String path, ImageIcon info) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
