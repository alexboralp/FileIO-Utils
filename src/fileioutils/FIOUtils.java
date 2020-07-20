/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioutils;

import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author aborbon
 */
public class FIOUtils {
    
    public static String getCurrentFolder() {
        return System.getProperty("user.dir");
    }
    
    public static String[] getFolderContent(String path) {
        return new File(path).list();
    }
    
    public static ImageIcon ImageIconLoadAndScale(String path, double scale) throws IOException {
        ImageIcon imageIcon = (ImageIcon)FIOFact.create(path).read(path);
        int nw = (int)(imageIcon.getIconWidth() * scale);
        int nh = (int)(imageIcon.getIconHeight() * scale);
        return new ImageIcon(imageIcon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }
    
    public static BufferedWriter openFile(String path) throws IOException {
        return new BufferedWriter(new FileWriter(path, true));
    }
    
    public static void appendToFile(BufferedWriter writer, String message) throws IOException {
        writer.newLine();   //Add new line
        writer.write(message);
        writer.flush();
    }
    
    public static void closeFile(BufferedWriter writer) throws IOException {
        writer.close();
    }
}
