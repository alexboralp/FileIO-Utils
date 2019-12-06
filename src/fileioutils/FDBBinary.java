/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author alexander
 */
public class FDBBinary implements FIDB{

    private static FDBBinary dbBinary;
    
    private FDBBinary() { }
    
    public static FDBBinary getInstance() {
        if (dbBinary == null) {
            dbBinary = new FDBBinary();
        }
        
        return dbBinary;
    }

    @Override
    public Object read(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }

    @Override
    public void write(String path, Object info) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
