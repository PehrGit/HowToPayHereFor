/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hmh.OldManOPA.model.decorator;

import java.util.Vector;
import nl.hmh.OldManOPA.model.INode;
import nl.hmh.OldManOPA.model.Node;
/**
 *
 * @author Pehr
 */
public class INodeDecorator implements INode{

    public INode component;
//    Vector<INode> inputNodes;
//    Vector<INode> outputNodes;
    
    public INodeDecorator(Node component) {
        this.component = component;
    }
    
    @Override
    public boolean calculate(int iter) {
        if(this.component.calculate(iter))
            return true;
        return false;
        
    }

    @Override
    public void addInputNode(INode newInputNode) {
        this.component.addInputNode(newInputNode);
    }

    @Override
    public void addOutputNode(INode newOutputNode) {
        this.component.addOutputNode(newOutputNode);
    }
}
