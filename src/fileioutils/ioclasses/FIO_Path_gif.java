/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses;

import java.io.IOException;
import fileioutils.ioclasses.interfaces.FIOI;
import javax.swing.ImageIcon;

/**
 *
 * @author alexander
 */
public class FIO_Path_gif implements FIOI<ImageIcon, ImageIcon> {
    
    private static FIO_Path_gif fioPathGif;
    
    private FIO_Path_gif() {
    }
    
    public static FIO_Path_gif getInstance() {
        if (fioPathGif == null) {
            fioPathGif = new FIO_Path_gif();
        }
        
        return fioPathGif;
    }

    @Override
    public ImageIcon read(String path) throws IOException {
        return FIO_ImageIcon.getInstance().read(path);
    }

    @Override
    public void write(String path, ImageIcon info) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
