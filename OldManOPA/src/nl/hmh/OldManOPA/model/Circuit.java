/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hmh.OldManOPA.model;

import java.util.Vector;

/**
 *
 * @author Pehr
 */
public class Circuit {
    Vector<INode> probes;
    
    public Circuit(Vector<INode> probes){
        this.probes = probes;
    }
    
    public void startCircuit(){
        
    }
           
}
