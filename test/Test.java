
import fileioutils.FIOFact;
import fileioutils.FIOUtils;
import fileioutils.ioclasses.interfaces.FIOI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexander
 */
public class Test {
    public static void main(String[] args) {
        FIOI fioi = FIOFact.create("txt");
        try {
            System.out.println(FIOUtils.getCurrentFolder() + "\\Hola.txt");
            
            fioi.write(FIOUtils.getCurrentFolder() + "\\Hola.txt", "Prueba");
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
