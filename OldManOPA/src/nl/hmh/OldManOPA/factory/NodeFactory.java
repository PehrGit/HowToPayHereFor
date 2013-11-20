/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hmh.OldManOPA.factory;

import nl.hmh.OldManOPA.strategy.*;

import nl.hmh.OldManOPA.model.Node;
import nl.hmh.OldManOPA.model.INode;
import nl.hmh.OldManOPA.model.IStrategy;
import nl.hmh.OldManOPA.model.decorator.INodeConcreteDecorator;

/**
 *
 * @author Pehr
 */
public class NodeFactory {

	public INode produceNode(String type) {
		IStrategy strategy = null;
		
		switch (type.toUpperCase()) {
			case "INPUT_LOW":
				strategy = new Input();
				((Input) strategy).setValue(false);
			break;
			case "INPUT_HIGH":
				strategy = new Input();
				((Input) strategy).setValue(true);
			break;
			case "AND":
				strategy = new AND();
			break;
			case "NAND":
				strategy = new NAND();
			break;
			case "OR":
				strategy = new OR();
			break;
			case "NOR":
				strategy = new NOR();
			break;
			case "XOR":
				strategy = new XOR();
			break;
			case "NOT":
				strategy = new NOT();
			break;
			case "PROBE":
				strategy = new Probe();
			break;
		}

		Node node = new Node(strategy);
		return new INodeConcreteDecorator(node);
	}
}
