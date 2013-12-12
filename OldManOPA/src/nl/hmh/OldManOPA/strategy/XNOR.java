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
public class XNOR extends Strategy {

	/*** Start of Singleton implementation ***/

	private static XNOR instance = new XNOR("XNOR");

	private static XNOR getInstance() {
		return instance;
	}

	/*** End of Singleton implementation ***/

	private XNOR(String ID) {
		super(ID);
	}

	@Override
	public boolean calculate(Vector<INode> inputNodes) {
		boolean result[] = new boolean[2];

		for (int i = 0; i < inputNodes.size(); i++) {
			if (inputNodes.get(i).calculate()) {
				result[0] = true;
			}
			else {
				result[1] = true;
			}

			// Check if both values have already been seen
			if (result[0] && result[1]) return false;
		}

		return true;
	}
    
}
