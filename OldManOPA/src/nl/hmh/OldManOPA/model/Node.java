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
public class Node implements INode {
    
    Strategy strategy;
    Vector<INode> inputNodes;
    Vector<INode> outputNodes;
    
    public Node(Strategy strategy) {
        this.strategy = strategy;
        inputNodes = new Vector<INode>();
        outputNodes = new Vector<INode>();
    }
    
    public boolean calculate(int iter) {
        if(iter > 0){
		if(this.strategy.calculate(this.inputNodes, --iter))
            return true;      
        return false;
        }
        else{
            throw new ArithmeticException("Loop detected");       
        }
    }

    @Override
    public void addInputNode(INode newInputNode) {
        this.inputNodes.add(newInputNode);
    }

    @Override
    public void addOutputNode(INode newOutputNode) {
        this.outputNodes.add(newOutputNode);
    }
    
    public Strategy getStrategy()
    {
        return strategy;
    }
    
}
