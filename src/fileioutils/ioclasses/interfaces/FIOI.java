/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils.ioclasses.interfaces;

import java.io.IOException;

/**
 *
 * @author alexander
 * @param <T>
 * @param <Q>
 */
public interface FIOI<T, Q> {
    public T read(String path) throws IOException;
    public void write(String path, Q info) throws IOException;
}
