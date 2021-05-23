package com.company.discoveryserver;

import java.lang.*;
import java.util.*;

public class Status {

    public static void showStatus() {
        printNodeMap();
        printMap();
        System.out.println("\n");
    }

    public static void printMap() {
        int counter = 0;
        for (Map.Entry<Integer, File> integerFileEntry : fileHandler.filesMap.entrySet()) {
            counter++;
            System.out.println("File " + counter + " with Name: " + integerFileEntry.getValue().getFilename() + ", ID: " + integerFileEntry.getKey());
        }
    }

    public static void printNodeMap() {
        System.out.println("\nAmount of nodes in the network: " + nodeHandler.nodesMap.size());
        int counter = 0;
        for (Map.Entry<Integer, String> integerStringEntry : nodeHandler.nodesMap.entrySet()) {
            counter++;
            System.out.println("Node " + counter + " with IP: " + integerStringEntry.getValue() + ", || Previous ID: " + nodeHandler.getPrevious(Integer.toString(integerStringEntry.getKey())) + " || with ID: " + integerStringEntry.getKey() + "|| Next ID: " + nodeHandler.getNext(Integer.toString(integerStringEntry.getKey())));
        }
    }
}
