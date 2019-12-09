/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import fileioutils.ioclasses.interfaces.FIOI;
import java.io.FileOutputStream;

/**
 *
 * @author alexander
 */
public class FIO_Binary implements FIOI<byte[], byte[]> {

    private static FIO_Binary fioBinary;
    
    private FIO_Binary() { }
    
    public static FIO_Binary getInstance() {
        if (fioBinary == null) {
            fioBinary = new FIO_Binary();
        }
        
        return fioBinary;
    }

    @Override
    public byte[] read(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }

    @Override
    public void write(String path, byte[] info) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            outputStream.write(info);
        }
    }
    
}
