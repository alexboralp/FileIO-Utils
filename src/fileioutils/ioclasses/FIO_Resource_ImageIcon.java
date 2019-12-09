/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import fileioutils.ioclasses.interfaces.FIOI;

/**
 *
 * @author alexander
 */
public class FIO_Resource_ImageIcon implements FIOI<ImageIcon, ImageIcon> {

    private static FIO_Resource_ImageIcon fioResourceImageIcon;
    
    private FIO_Resource_ImageIcon() {
        
    }
    
    public static FIO_Resource_ImageIcon getInstance() {
        if (fioResourceImageIcon == null) {
            fioResourceImageIcon = new FIO_Resource_ImageIcon();
        }
        
        return fioResourceImageIcon;
    }
    
    @Override
    public ImageIcon read(String resourcePath) {
        try {
            return new ImageIcon(FIO_Resource_Binary.getInstance().read(resourcePath));
        } catch (IOException ex) {
            Logger.getLogger(FIO_Resource_ImageIcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void write(String path, ImageIcon info) throws IOException {
        throw new UnsupportedOperationException("You can not write to a Resource file."); //To change body of generated methods, choose Tools | Templates.
    }
}
