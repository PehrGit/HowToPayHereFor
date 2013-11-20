/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hmh.OldManOPA.model;

import java.util.Vector;

/**
 *
 * @author Steven
 */
public interface IStrategy {

    boolean calculate(Vector<INode> inputNodes);

}
