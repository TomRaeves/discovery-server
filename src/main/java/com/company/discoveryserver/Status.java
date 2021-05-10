package com.company.discoveryserver;

import java.lang.*;
import java.util.*;

public class Status {

        public static void showStatus() {
                System.out.println("\nAmount of nodes in the network: " + nodeHandler.nodesMap.size());
                System.out.println("Map: " + nodeHandler.nodesMap);
                printMap();
                System.out.println("\n");
        }

        public static void printMap(){
                int counter=0;
                Iterator<Map.Entry<Integer, File>> iterator = fileHandler.filesMap.entrySet().iterator();
                while (iterator.hasNext()) {
                        counter++;
                        Map.Entry<Integer, File> entry = iterator.next();
                        System.out.println("File "+counter+" with Name: "+entry.getValue().getFilename()+", ID: "+entry.getKey());
                }
        }
}
