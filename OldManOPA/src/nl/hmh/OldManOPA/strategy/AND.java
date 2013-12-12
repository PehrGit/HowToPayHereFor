/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hmh.OldManOPA.strategy;

import java.util.Vector;
import nl.hmh.OldManOPA.model.INode;
import nl.hmh.OldManOPA.model.Strategy;

/**
 *
 * @author Steven
 */
public class AND extends Strategy {

	/*** Start of Singleton implementation ***/

	private static AND instance = new AND("AND");

	private static AND getInstance() {
		return instance;
	}

	/*** End of Singleton implementation ***/

	private AND(String ID) {
		super(ID);
	}

	@Override
	public boolean calculate(Vector<INode> inputNodes) {
		for (int i = 0; i < inputNodes.size(); i++) {
			if (!inputNodes.get(i).calculate()) return false;
		}

		return true;
	}
    
}
