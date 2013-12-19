/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hmh.OldManOPA.model;

import java.util.Vector;
import nl.hmh.OldManOPA.factory.NodeFactory;

/**
 *
 * @author Steven
 */
public abstract class Strategy {

	protected Strategy(String ID) {
		NodeFactory.assign(ID, this);
	}

    public abstract boolean calculate(Vector<INode> inputNodes, int iter);

}
