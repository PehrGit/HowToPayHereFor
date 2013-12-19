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
public class PROBE extends Strategy {

	/*** Start of Singleton implementation ***/

	private static PROBE instance = new PROBE("PROBE");

	private static PROBE getInstance() {
		return instance;
	}

	/*** End of Singleton implementation ***/

	private PROBE(String ID) {
		super(ID);
	}

	@Override
	public boolean calculate(Vector<INode> inputNodes, int iter) {
		return inputNodes.get(0).calculate(iter);
	}
    
}