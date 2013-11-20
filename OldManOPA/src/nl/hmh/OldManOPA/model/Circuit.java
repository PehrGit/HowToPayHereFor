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

    public Circuit(HashMap<String, INode> probes) {
        this.probes = probes;
    }

    public void startCircuit() {
        for(Entry<String, INode> entry: probes.entrySet()){
            String name = entry.getKey();
            int value = entry.getValue().calculate() ? 1: 0;
            
            System.out.println("Probe '" + name + "'\t=" + value);
        }
    }
}
