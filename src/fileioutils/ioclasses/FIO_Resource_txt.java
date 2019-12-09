/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import fileioutils.ioclasses.interfaces.FIOI;

/**
 *
 * @author alexander
 */
public class FIO_Resource_txt implements FIOI<String, String> {

    private static FIO_Resource_txt fioResourceTxt;
    
    private FIO_Resource_txt() {
        
    }
    
    public static FIO_Resource_txt getInstance() {
        if (fioResourceTxt == null) {
            fioResourceTxt = new FIO_Resource_txt();
        }
        
        return fioResourceTxt;
    }
    
    @Override
    public String read(String resourcePath) {
        try {
            return new String(FIO_Resource_Binary.getInstance().read(resourcePath));
        } catch (IOException ex) {
            Logger.getLogger(FIO_Resource_txt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void write(String resourcePath, String info) throws IOException {
        throw new UnsupportedOperationException("You can not write to a Resource file."); //To change body of generated methods, choose Tools | Templates.
    }
}
