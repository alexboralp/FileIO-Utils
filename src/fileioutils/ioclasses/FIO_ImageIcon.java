/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses;

import java.io.IOException;
import javax.swing.ImageIcon;
import fileioutils.ioclasses.interfaces.FIOI;

/**
 *
 * @author alexander
 */
public class FIO_ImageIcon implements FIOI<ImageIcon, ImageIcon> {

    private static FIO_ImageIcon fioImageIcon;
    
    private FIO_ImageIcon() { }
    
    public static FIO_ImageIcon getInstance() {
        if (fioImageIcon == null) {
            fioImageIcon = new FIO_ImageIcon();
        }
        
        return fioImageIcon;
    }

    @Override
    public ImageIcon read(String path) throws IOException {
        return new ImageIcon(path);
    }

    @Override
    public void write(String path, ImageIcon info) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}