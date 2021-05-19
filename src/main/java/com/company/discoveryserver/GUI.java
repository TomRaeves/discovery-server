package com.company.discoveryserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Map;


public class GUI extends JPanel {

    private int counter = 1;

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
        JTextField textfield = new JTextField("enter node name here");
        panel.add(button); // Components Added using Flow Layout
        panel.add(button2); // Components Added using Flow Layout
        panel.add(button3); // Components Added using Flow Layout
        panel.add(button4); // Components Added using Flow Layout
        panel.add(textfield);
        frame.setVisible(true);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String IP = "10.0.0." + counter;
                nodeHandler.addNode(textfield.getText(), IP);
                counter++;
                if (counter == 2)
                    fileHandler.addFile("test.txt", nodeHandler.nodesMap);
                if (counter == 3)
                    fileHandler.addFile("tom.txt", nodeHandler.nodesMap);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nodeHandler.removeNodeviaName(textfield.getText());
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Status.printNodeMap();

            }
        });

        button4.addActionListener(new ActionListener() { // Find files located on a node
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nodeHandler.nodesMap.size() > 0) {
                    String name = textfield.getText();
                    int ID = Hasher.hashCode(name);
                    for (Map.Entry<Integer, File> entry : fileHandler.filesMap.entrySet()) {
                        if (ID == fileHandler.searchFileint(fileHandler.filesMap, entry.getValue().getFilename())) {
                            System.out.println("Found file " + entry.getValue().getFilename() + " located at node " + name);
                        }
                    }
                }
                else
                    System.out.println("First add some nodes!");
            }

        });

    }


}