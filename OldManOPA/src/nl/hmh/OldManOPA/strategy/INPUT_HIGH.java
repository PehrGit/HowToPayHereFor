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
public class INPUT_HIGH extends Strategy {

	/*** Start of Singleton implementation ***/

	private static INPUT_HIGH instance = new INPUT_HIGH("INPUT_HIGH");

	private static INPUT_HIGH getInstance() {
		return instance;
	}

	/*** End of Singleton implementation ***/

	private boolean value = true;

	private INPUT_HIGH(String ID) {
		super(ID);
	}

	@Override
	public boolean calculate(Vector<INode> inputNodes) {
		return this.value;
	}
    
}
