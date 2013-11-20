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
public class INodeConcreteDecorator extends INodeDecorator {

    public INodeConcreteDecorator(Node component) {
        super(component);
    }
    
    void writeResult(boolean result){
        System.out.println((result ? "true \n" : "false \n"));
    }
    
    @Override
    public boolean calculate() {
        boolean result = this.component.calculate();
        writeResult(result);
        if(result)
            return true;
        return false;
    }
    
}
