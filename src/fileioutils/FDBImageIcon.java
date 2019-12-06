/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author alexander
 */
public class FDBImageIcon implements FIDB<ImageIcon, ImageIcon> {

    private static FDBImageIcon dbImageIcon;
    
    private FDBImageIcon() { }
    
    public static FDBImageIcon getInstance() {
        if (dbImageIcon == null) {
            dbImageIcon = new FDBImageIcon();
        }
        
        return dbImageIcon;
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