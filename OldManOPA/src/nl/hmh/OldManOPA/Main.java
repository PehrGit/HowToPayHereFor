/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hmh.OldManOPA;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.hmh.OldManOPA.data.FileParser;
import nl.hmh.OldManOPA.model.Circuit;

/**
 *
 * @author Steven
 */
public class Main {
	/**
	 * This method makes sure there cannot occure a infinity loop.
	 */
	public static final int MAX_ENTRIES = 1000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileParser fileParser = FileParser.getInstance();
        
        
        while(true){            
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("Geef path van bestand");
                
                String s = bufferRead.readLine();
                //test
                //String s = "D:\\circuit5.txt";
                if(s.equals("exit")){
                    System.out.println("Goodbye");
                    System.exit(0);
                    //test
                    throw new IOException();
                }
                else{
                    File f = new File(s);
                    if(f.exists() && !f.isDirectory()) { /* do something */ }
                    Circuit circuit = fileParser.parseFile(f);
                    try{
                    circuit.startCircuit();
                    }
                    catch(ArithmeticException e)
                    {
                        System.out.println("");
                        System.out.println("Error: ");
                        System.out.println(e.getMessage());
                        
                    }
                    System.out.println("");
                }
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
    }
}
