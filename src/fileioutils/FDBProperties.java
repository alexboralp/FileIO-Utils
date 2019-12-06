/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author alexander
 */
public class FDBProperties implements FIDB<Properties, Properties> {

    private static FDBProperties dbProperties;
    
    private FDBProperties() { }
    
    public static FDBProperties getInstance() {
        if (dbProperties == null) {
            dbProperties = new FDBProperties();
        }
        
        return dbProperties;
    }

    @Override
    public Properties read(String path) throws IOException {
        Properties properties;
        try (FileReader reader = new FileReader(path)) {
            properties = new Properties();
            properties.load(reader);
        }
        return properties;
    }

    @Override
    public void write(String path, Properties info) throws IOException {
        try (FileOutputStream fr = new FileOutputStream(path)) {
            info.store(fr, "");
        }
    }
    
}
