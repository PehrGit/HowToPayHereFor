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
public class Probe implements IStrategy {

	@Override
	public boolean calculate(Vector<INode> inputNodes) {
		return inputNodes.get(0).calculate();
	}
    
}
