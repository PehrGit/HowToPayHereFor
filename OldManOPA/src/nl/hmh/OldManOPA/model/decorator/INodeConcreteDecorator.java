/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hmh.OldManOPA.model.decorator;

import java.util.Vector;
import nl.hmh.OldManOPA.model.INode;

/**
 *
 * @author Pehr
 */
public class INodeConcreteDecorator extends INodeDecorator {

   
    void writeResult(){
        
    }
    
    @Override
    public boolean calculate(Vector<INode> inputNodes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
