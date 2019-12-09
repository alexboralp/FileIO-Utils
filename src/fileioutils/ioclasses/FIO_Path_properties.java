/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import fileioutils.ioclasses.interfaces.FIOI;

/**
 *
 * @author alexander
 */
public class FIO_Path_properties implements FIOI<Properties, Properties> {

    private static FIO_Path_properties fioPathProperties;
    
    private FIO_Path_properties() { }
    
    public static FIO_Path_properties getInstance() {
        if (fioPathProperties == null) {
            fioPathProperties = new FIO_Path_properties();
        }
        
        return fioPathProperties;
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
