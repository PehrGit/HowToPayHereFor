/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hmh.OldManOPA.model;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

/**
 *
 * @author Pehr
 */
public class Circuit {

    HashMap<String, INode> probes;
    
    int size;
    
    public int GetSize()
    {
        return size;
    }

    public Circuit(HashMap<String, INode> probes, int size) {
        this.probes = probes;
        this.size = size;
    }

    public void startCircuit() {
        for(Entry<String, INode> entry: probes.entrySet()){
            String name = entry.getKey();
            int value = entry.getValue().calculate(size) ? 1: 0;
            
            System.out.println("Probe '" + name + "'\t=" + value);
        }
    }
}
