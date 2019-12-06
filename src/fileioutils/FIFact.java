/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

/**
 *
 * @author alexander
 * @param <T>
 * @param <Q>
 */
public interface FIFact<T, Q> {
    public T create();
    public T create(Q tipo);
    public T create(String className);
}
