/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

import java.io.IOException;

/**
 *
 * @author aborbon
 * @param <T>
 */
public interface FIFile <T> {
    public void openFile(String path) throws IOException;
    public void appendToFile(T message) throws IOException;
    public void closeFile() throws IOException;
}
