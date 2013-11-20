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
public class Node implements INode{
    
    IStrategy strategy;
    
    public Node(IStrategy strategy) {
        this.strategy = strategy;
    }
    
    public boolean calculate() {
        if(this.strategy.calculate(this.inputNodes))
            return true;
        return false;
    }

    @Override
    public void addInputNode(INode newInputNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOutputNode(INode newOutputNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
