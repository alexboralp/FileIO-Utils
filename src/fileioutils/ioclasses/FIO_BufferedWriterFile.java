/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses;

import fileioutils.FIOUtils;
import java.io.BufferedWriter;
import java.io.IOException;
import fileioutils.ioclasses.interfaces.FIOFileI;

/**
 *
 * @author aborbon
 */
public class FIO_BufferedWriterFile implements FIOFileI<String> {
    BufferedWriter bufferWriter;

    public FIO_BufferedWriterFile() {}

    @Override
    public void openFile(String path) throws IOException {
        this.bufferWriter = FIOUtils.openFile(path);
    }

    @Override
    public void appendToFile(String message) throws IOException {
        FIOUtils.appendToFile(bufferWriter, message);
    }

    @Override
    public void closeFile() throws IOException {
        FIOUtils.closeFile(bufferWriter);
    }
}
