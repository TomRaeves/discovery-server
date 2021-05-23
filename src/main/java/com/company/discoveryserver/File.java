package com.company.discoveryserver;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Collections.max;

public class File {

    private String filename;
    private final int nodeID;
    private int hash;


    public File(String filename, ConcurrentHashMap<Integer, String> nodes) {
        this.filename = filename;
        this.hash = Hasher.hashCode(filename); //key van file Hashmap
        this.nodeID = setNodeID(nodes); //Key van nodes hashMap
    }

    public String getFilename() {
        return filename;
    }

    public int getHash() {
        return hash;
    }

    public int getNodeID() {
        return nodeID;
    }

    public void setFilename(String filename) {
        this.filename = filename;
        this.hash = Hasher.hashCode(filename);
    }

    public int setNodeID(ConcurrentHashMap<Integer, String> nodes) {
        ArrayList<Integer> smallerKey = new ArrayList<>();
        ArrayList<Integer> biggerKey = new ArrayList<>();

        for (ConcurrentHashMap.Entry<Integer, String> entry : nodes.entrySet()) {
            if (entry.getKey() < hash) {
                smallerKey.add(entry.getKey());
            } else {
                biggerKey.add(entry.getKey());
            }
        }
        if (smallerKey.size() == 0) {
            return max(biggerKey);
        } else {
            return max(smallerKey);
        }

    }

}