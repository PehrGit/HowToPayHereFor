/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hmh.OldManOPA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pehr
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while(true){            
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            try {
                String s = bufferRead.readLine();
                System.out.println("you typed: " + s);
                
                if(s.equals("exit")){
                    System.out.println("Goodbye");
                    System.exit(0);
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
    }
}
