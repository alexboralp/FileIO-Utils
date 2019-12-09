/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import fileioutils.ioclasses.interfaces.FIOI;

/**
 *
 * @author alexander
 */
public class FIO_Path_json implements FIOI<String, Object> {
    
    private static FIO_Path_json fioPathJson;
    Gson jsonConverter;
    
    private FIO_Path_json() {
        jsonConverter = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
    }
    
    public static FIO_Path_json getInstance() {
        if (fioPathJson == null) {
            fioPathJson = new FIO_Path_json();
        }
        
        return fioPathJson;
    }

    @Override
    public String read(String path) throws IOException {
        return new String ( (byte[])FIO_Binary.getInstance().read(path) );
    }
    
    public Object readObject(String path, Class cl) throws IOException {
        return jsonConverter.fromJson(read(path), cl);
    }
    
    public Object jsonToObject(String json, Class cl) throws IOException {
        return jsonConverter.fromJson(json, cl);
    }

    @Override
    public void write(String path, Object info) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(jsonConverter.toJson(info));
        }
    }
    
}
