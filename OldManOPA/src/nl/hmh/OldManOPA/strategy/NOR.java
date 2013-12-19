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
public class NOR extends Strategy {

	/*** Start of Singleton implementation ***/

	private static NOR instance = new NOR("NOR");

	private static NOR getInstance() {
		return instance;
	}

	/*** End of Singleton implementation ***/

	private NOR(String ID) {
		super(ID);
	}

	@Override
	public boolean calculate(Vector<INode> inputNodes, int iter) {
		for (int i = 0; i < inputNodes.size(); i++) {
			if (inputNodes.get(i).calculate(iter)) return false;
		}

		return true;
	}
    
}
