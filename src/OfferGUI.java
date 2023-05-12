/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amir
 */

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class OfferGUI extends JFrame implements ActionListener {
    
    private JTextField priceField;
    private JTextArea productsArea;
    private JButton addButton;
    
    public OfferGUI() {
        setTitle("WDP engine");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(250, 250, 250));
        setLayout(new BorderLayout());

        // Top panel with input fields
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        topPanel.setBackground(new Color(100, 100, 100));
        JLabel titleLabel = new JLabel("WDP        ",SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(titleLabel);
        topPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        JPanel pricePanel = new JPanel(new BorderLayout());
        JLabel priceLabel = new JLabel("Price (integer):");
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        pricePanel.add(priceLabel, BorderLayout.NORTH);
        priceField = new JTextField();
        priceField.setFont(new Font("Arial", Font.PLAIN, 16));
        priceField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        priceField.setPreferredSize(new Dimension(priceField.getPreferredSize().width, 30));
        pricePanel.add(priceField, BorderLayout.CENTER);
        topPanel.add(pricePanel);
        topPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel productsPanel = new JPanel(new BorderLayout());
        JLabel productsLabel = new JLabel("Products (one per line):");
        productsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        productsPanel.add(productsLabel, BorderLayout.NORTH);
        productsArea = new JTextArea();
        productsArea.setFont(new Font("Arial", Font.PLAIN, 16));
        productsArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        productsArea.setMinimumSize(new Dimension(priceField.getPreferredSize().width, 200));
        JScrollPane scrollPane = new JScrollPane(productsArea);
        scrollPane.setPreferredSize(new Dimension(priceField.getPreferredSize().width, 200));
        productsPanel.add(scrollPane, BorderLayout.CENTER);
        topPanel.add(productsPanel);
        add(topPanel, BorderLayout.CENTER);

        // Bottom panel with add button
        
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(new Color(100, 100, 100));
        addButton = new JButton("Add");
        addButton = new JButton("Add");
        addButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addButton.setBackground(new Color(60, 179, 113));
        addButton.setForeground(Color.WHITE);
        addButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addButton.addActionListener(this);
        bottomPanel.add(addButton);

        // Add a new button
        JButton testButton = new JButton("add test set");
        testButton.setFont(new Font("Arial", Font.PLAIN, 16));
        testButton.setBackground(new Color(60, 179, 113));
        testButton.setForeground(Color.WHITE);
        testButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        testButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for test button action
                Offer.test1();
                JOptionPane.showMessageDialog(OfferGUI.this, "test set 1 is ready");
            }
        });
        bottomPanel.add(testButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // JADE container button
        JButton runButton = new JButton("> Click To Run Agents <");
        runButton.setFont(new Font("Arial", Font.PLAIN, 16));
        runButton.setForeground(Color.WHITE);
        runButton.setBackground(new Color(41, 128, 185));
        runButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jade.core.Runtime r= jade.core.Runtime.instance();
                Properties pr = new ExtendedProperties();
                pr.setProperty("gui", "true");
                Profile p = new ProfileImpl(pr);
                ContainerController mainc = r.createMainContainer(p);
                Profile p2 = new ProfileImpl();
                ContainerController cc = r.createAgentContainer(p2);
                AgentController a2;
                try {
                    a2 = cc.createNewAgent("master", "Master", null);
                    a2.start();
                } catch (StaleProxyException ex) {
                    Logger.getLogger(OfferGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        add(runButton, BorderLayout.NORTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String priceText = priceField.getText();
            String productsText = productsArea.getText();
            if (priceText.isEmpty() || productsText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a price and at least one product.");
                return;
            }
            int price;
            try {
                price = Integer.parseInt(priceText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid integer price.");
                return;
            }
            String[] products = productsText.split("\n");
            Offer offer = new Offer(price);
            for (String product : products) {
                offer.add(product);
            }
            priceField.setText("");            
            productsArea.setText("");
            // Do something with the offer, such as add it to a list or database
            // Or pass it to an agent for negotiation
            System.out.println("Offer added: " + offer.toString());
        }
    }
    
    
    
}