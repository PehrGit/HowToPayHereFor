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
public class INPUT_LOW extends Strategy {

	/*** Start of Singleton implementation ***/

	private static INPUT_LOW instance = new INPUT_LOW("INPUT_LOW");

	private static INPUT_LOW getInstance() {
		return instance;
	}

	/*** End of Singleton implementation ***/

	private boolean value = false;

	private INPUT_LOW(String ID) {
		super(ID);
	}

	@Override
	public boolean calculate(Vector<INode> inputNodes, int iter) {
		return this.value;
	}
    
}
