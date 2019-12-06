/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author aborbon
 */
public class FBufferedWriterFile implements FIFile<String> {
    BufferedWriter bufferWriter;

    public FBufferedWriterFile() {}

    @Override
    public void openFile(String path) throws IOException {
        this.bufferWriter = FUtils.openFile(path);
    }

    @Override
    public void appendToFile(String message) throws IOException {
        FUtils.appendToFile(bufferWriter, message);
    }

    @Override
    public void closeFile() throws IOException {
        FUtils.closeFile(bufferWriter);
    }
}
