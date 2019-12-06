/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author alexander
 */
public class FDBJson implements FIDB<String, Object> {
    
    private static FDBJson dbJson;
    Gson jsonConverter;
    
    private FDBJson() {
        jsonConverter = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
    }
    
    public static FDBJson getInstance() {
        if (dbJson == null) {
            dbJson = new FDBJson();
        }
        
        return dbJson;
    }

    @Override
    public String read(String path) throws IOException {
        return new String ( (byte[])FDBBinary.getInstance().read(path) );
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
