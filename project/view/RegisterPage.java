package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage extends JFrame implements ActionListener{
    private JButton registerButton;
    private TextField usersName=new TextField(1);
    private TextField code=new TextField(1);
    private JButton quitButton;

    public RegisterPage() {
        setTitle("Register Page");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        registerButton = new JButton("注册");
        quitButton=new JButton("退出");

        quitButton.addActionListener(this);
        registerButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.add(registerButton);

        add(panel);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Register button clicked");
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {}
}