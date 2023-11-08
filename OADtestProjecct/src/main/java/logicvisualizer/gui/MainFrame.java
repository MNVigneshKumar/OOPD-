package logicvisualizer.gui;

import logicvisualizer.node.NodeMap;
import logicvisualizer.node.NodeRegistry;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Logic Builder");
        setSize(810, 725);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
            System.err.println("Failed to set look and feel");
        }

        setupComponents();
    }

    private void setupComponents() {
        NodePanel nodePanel = new NodePanel();
        nodePanel.setBounds(5, 5, 785, 650);
        nodePanel.setBorder(new LineBorder(Color.BLACK));

        JComboBox<String> nodeChooser = new JComboBox<>();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (NodeMap node : NodeMap.values()) {
            model.addElement(node.getItemName());
        }
        nodeChooser.setModel(model);
        nodeChooser.setBounds(5, 660, 100, 20);

        JButton addButton = new JButton("Add");
        addButton.setBounds(110, 660, 60, 20);
        addButton.addActionListener(getAddButtonListener(nodeChooser, nodePanel));

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(720, 660, 70, 20);
        clearButton.addActionListener(getClearButtonListener(nodePanel));


        JButton saveButton = new JButton("Save");
        saveButton.setBounds(620, 660, 70, 20);
        saveButton.addActionListener(getSaveButtonListener(nodePanel));


        add(nodePanel);
        add(nodeChooser);
        add(addButton);
        add(saveButton);
        add(clearButton);
    }

    private ActionListener getSaveButtonListener(NodePanel nodePanel) {
        return e -> {
            // Perform the save operation or any desired action here
            // For example, you can save data or update the NodePanel.
            // nodePanel.saveData(); // Replace with the appropriate save method
            // nodePanel.repaint(); // Repaint the panel if needed
        };
    }


    private ActionListener getAddButtonListener(JComboBox<String> nodeChooser, NodePanel panel) {
        return e -> {
            if (nodeChooser.getSelectedItem() == null) {
                return;
            }

            NodeMap.getByName(nodeChooser.getSelectedItem().toString()).run();
            panel.repaint();
        };
    }

    private ActionListener getClearButtonListener(NodePanel panel) {
        return e -> {
            new HashSet<>(NodeRegistry.getNodes()).forEach(NodeRegistry::safeRemove);
            panel.repaint();
        };
    }

}

