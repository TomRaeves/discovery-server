package com.company.discoveryserver;

import javax.swing.*;
import java.awt.*;

import java.util.Map;


public class GUI extends JPanel {

    private int counter = 1;
    private boolean found=false;

    public GUI() {
        JFrame frame = new JFrame("GUI");
        JPanel panel = new JPanel(new GridBagLayout()); // the panel is not visible in output
        frame.add(panel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 100);
        JButton button = new JButton("Add Node");
        JButton button2 = new JButton("Remove Node");
        JButton button3 = new JButton("Show Nodes");
        JButton button4 = new JButton("Show files of node");
        JTextField textField = new JTextField("enter node name here");
        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(textField);
        frame.setVisible(true);


        button.addActionListener(e -> {
            String IP = "10.0.0." + counter;
            nodeHandler.addNode(textField.getText(), IP);
            counter++;
            if (counter == 2)
                fileHandler.addFile("test.txt", nodeHandler.nodesMap);
            if (counter == 3)
                fileHandler.addFile("tom.txt", nodeHandler.nodesMap);
        });

        button2.addActionListener(e -> nodeHandler.removeNodeviaName(textField.getText()));

        button3.addActionListener(e -> Status.printNodeMap());

        // Find files located on a node
        button4.addActionListener(e -> {
            found=false;
            if (nodeHandler.nodesMap.size() > 0) {
                String name = textField.getText();
                int ID = Hasher.hashCode(name);
                for (Map.Entry<Integer, File> entry : fileHandler.filesMap.entrySet()) {
                    if (ID == fileHandler.searchFileint(fileHandler.filesMap, entry.getValue().getFilename())) {
                        found=true;
                        System.out.println("Found file " + entry.getValue().getFilename() + " located at node " + name);
                    }
                }
                if(!found){
                    System.out.println("Didn't find any files located at node "+name);
                }
            } else
                System.out.println("First add some nodes!");
        });

    }


}