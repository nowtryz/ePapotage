package net.nowtryz.epapotage.gui;

import net.nowtryz.epapotage.entity.Bavard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {
    private JTextField field = new JTextField();

    public LoginPage() {
        JButton button = new JButton("Connexion");
        button.addActionListener(this::createBavard);

        this.setTitle("Connexion");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(300,200));
        this.add(field);
        this.add(button, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private void createBavard(ActionEvent e) {
        new BavardWindow(new Bavard(field.getText()));
        field.setText("");
    }
}
