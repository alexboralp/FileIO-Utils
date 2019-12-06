/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author alexander
 */
public class FDBTxt implements FIDB<String, String> {

    private static FDBTxt dbTxt;
    
    private FDBTxt() { }
    
    public static FDBTxt getInstance() {
        if (dbTxt == null) {
            dbTxt = new FDBTxt();
        }
        
        return dbTxt;
    }

    @Override
    public String read(String path) throws IOException {
        return new String ( (byte[])FDBBinary.getInstance().read(path) );
    }

    @Override
    public void write(String path, String info) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(info);
        }
    }
    
}
