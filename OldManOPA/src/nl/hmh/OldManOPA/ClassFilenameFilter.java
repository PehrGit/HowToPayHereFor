/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hmh.OldManOPA;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Steven
 */
public class ClassFilenameFilter implements FilenameFilter {
    public boolean accept(File cFile, String name) {
        return name.endsWith(".class") && name.indexOf('$') == -1;
    }
	
}
