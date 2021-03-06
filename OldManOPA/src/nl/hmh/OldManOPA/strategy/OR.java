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
public class OR extends Strategy {

	/*** Start of Singleton implementation ***/

	private static OR instance = new OR("OR");

	private static OR getInstance() {
		return instance;
	}

	/*** End of Singleton implementation ***/

	private OR(String ID) {
		super(ID);
	}

	@Override
	public boolean calculate(Vector<INode> inputNodes, int iter) {
		for (int i = 0; i < inputNodes.size(); i++) {
			if (inputNodes.get(i).calculate(iter)) return true;
		}

		return false;
	}
    
}
