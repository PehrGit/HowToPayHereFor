/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hmh.OldManOPA.data;

import java.io.File;
import java.nio.file.Path;
import nl.hmh.OldManOPA.factory.NodeFactory;
import nl.hmh.OldManOPA.model.Circuit;


        
/**
 *
 * @author Pehr
 */
public class FileParser {
    private NodeFactory nodeFactory;
    
    private static FileParser instance = null;
    
    protected FileParser(){
        nodeFactory = new NodeFactory();
    }
    
    public static FileParser getInstance(){
        if(instance == null)
            instance = new FileParser();
        
        return instance;
    }
    
    public Circuit parseFile(File file){
        //read file
        
        //save nodes in map/dictionary
        
        //save probes in Circuit
        
        //connect nodes
        
        //return Circuit
        
        
        return null;    
    }
}
