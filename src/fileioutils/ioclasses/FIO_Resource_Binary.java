/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses;

import java.io.IOException;
import fileioutils.ioclasses.interfaces.FIOI;
import java.io.InputStream;

/**
 *
 * @author alexander
 */
public class FIO_Resource_Binary implements FIOI<byte[], byte[]> {

    private static FIO_Resource_Binary fioResourceBinary;
    
    private FIO_Resource_Binary() { }
    
    public static FIO_Resource_Binary getInstance() {
        if (fioResourceBinary == null) {
            fioResourceBinary = new FIO_Resource_Binary();
        }
        
        return fioResourceBinary;
    }

    @Override
    public byte[] read(String resourcePath) throws IOException {
        InputStream in = getClass().getResourceAsStream(resourcePath);
        return in.readAllBytes();
    }

    @Override
    public void write(String path, byte[] info) throws IOException {
        throw new UnsupportedOperationException("You can not write to a Resource file."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
