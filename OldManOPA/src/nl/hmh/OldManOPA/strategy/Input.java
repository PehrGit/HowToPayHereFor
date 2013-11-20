/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hmh.OldManOPA.strategy;

import java.util.Vector;
import nl.hmh.OldManOPA.model.INode;
import nl.hmh.OldManOPA.model.IStrategy;

/**
 *
 * @author Steven
 */
public class Input implements IStrategy {

	private boolean value;

	public void setValue(boolean value)
	{
		this.value = value;
	}

	@Override
	public boolean calculate(Vector<INode> inputNodes) {
		return this.value;
	}
    
}
