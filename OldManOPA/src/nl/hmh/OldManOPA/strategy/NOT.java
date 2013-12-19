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
public class NOT extends Strategy {

	/*** Start of Singleton implementation ***/

	private static NOT instance = new NOT("NOT");

	private static NOT getInstance() {
		return instance;
	}

	/*** End of Singleton implementation ***/

	private NOT(String ID) {
		super(ID);
	}

	@Override
	public boolean calculate(Vector<INode> inputNodes, int iter) {
		if (inputNodes.size() == 0)
			throw new IndexOutOfBoundsException("[NOT] The size of the input cannot be zero.");

		return !inputNodes.get(0).calculate(iter);
	}
    
}