package com.company.discoveryserver;

public class Status {

        public static void showStatus() {
                System.out.println("\nAmount of nodes in the network: " + nodeHandler.nodesMap.size());
                System.out.println("Map: " + nodeHandler.nodesMap);
                System.out.println("FileMap: " + fileHandler.filesMap);
                System.out.println("\n");
        }
}
