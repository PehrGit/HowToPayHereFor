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
    Vector<INode> inputNodes;
    Vector<INode> outputNodes;
    
    public Node(IStrategy strategy) {
        this.strategy = strategy;
        inputNodes = new Vector<INode>();
        outputNodes = new Vector<INode>();
    }
    
    public boolean calculate() {
        if(this.strategy.calculate(this.inputNodes))
            return true;
        return false;
    }

    @Override
    public void addInputNode(INode newInputNode) {
        this.inputNodes.add(newInputNode);
    }

    @Override
    public void addOutputNode(INode newOutputNode) {
        this.outputNodes.add(newOutputNode);
    }
    
}
