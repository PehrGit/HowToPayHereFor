/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hmh.OldManOPA.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import nl.hmh.OldManOPA.factory.NodeFactory;
import nl.hmh.OldManOPA.model.Circuit;
import nl.hmh.OldManOPA.model.Constants;
import nl.hmh.OldManOPA.model.INode;

/**
 *
 * @author Pehr
 */
public class FileParser {

    private NodeFactory nodeFactory;
    private static FileParser instance = null;

    protected FileParser() {
        nodeFactory = new NodeFactory();
    }

    public static FileParser getInstance() {
        if (instance == null) {
            instance = new FileParser();
        }

        return instance;
    }

    public Circuit parseFile(File file) {
        HashMap<String, INode> nodes = new HashMap<String, INode>();
        HashMap<String, INode> probes = new HashMap<String, INode>();

        //read file
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //disregard comments
                if (!line.startsWith("#") && !line.equals("")) {
                    parseLine(line, nodes, probes);
                }
            }
            Circuit circuit = new Circuit(probes);
            return circuit;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            System.exit(1);
        }


        return null;
    }

    private void parseLine(String line, HashMap<String, INode> nodes, HashMap<String, INode> probes) throws IOException {
        //line = trimComment(line);
        line = trimLine(line, "#");

        String[] lineSplit = splitNameDescription(line);
        String nodeName = lineSplit[0];
        String nodeDescription = lineSplit[1];


        //Either add to nodes or
        if (Arrays.asList(Constants.operators).contains(nodeDescription)) {
            INode node = nodeFactory.produceNode(nodeDescription);
            nodes.put(nodeName, node);
            if(nodeDescription.equals("PROBE"))
                probes.put(nodeName, node);
        } else {
            //connect to node
            connectNode(nodeName, nodeDescription, nodes);
        }
    }

    private void connectNode(String nodeName, String nodeDescription, HashMap<String, INode> nodes) throws IOException {
        INode thisNode;

        if (nodes.containsKey(nodeName)) {
            thisNode = nodes.get(nodeName);
        } else {
            throw new IOException("Invalid line", new Throwable("Node not found"));
        }

        Scanner lineScanner = new Scanner(nodeDescription);
        lineScanner.useDelimiter("\\s*,\\s*");
        while (lineScanner.hasNext()) {
            String outputNodeName = lineScanner.next();
            if (nodes.containsKey(outputNodeName)) {
                INode outputNode = nodes.get(outputNodeName);

                thisNode.addOutputNode(outputNode);
                outputNode.addInputNode(thisNode);

            } else {
                throw new IOException("Invalid line", new Throwable("Node not found"));
            }
        }
    }

    private String[] splitNameDescription(String line) throws IOException {
        String[] returns = new String[2];
        //Get nodename
        Scanner scanner = new Scanner(line);
        //split on : and remove whitespace
        scanner.useDelimiter("\\s*:\\s*");

        if (scanner.hasNext()) {
            returns[0] = scanner.next();

            if (scanner.hasNext()) {
                line = scanner.next();
                returns[1] = trimLine(line, ";");
            } else {
                throw new IOException("Invalid line", new Throwable("No description specified"));
            }
        } else {
            throw new IOException("Invalid line", new Throwable("No nodeName specified"));
        }

        return returns;
    }

    private String trimLine(String line, String delimiter) {
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter("\\s*" + delimiter + "\\s*");
        if (lineScanner.hasNext()) {
            return lineScanner.next();
        }

        return null;
    }

    //
    //
    //
    //
//end class
}
