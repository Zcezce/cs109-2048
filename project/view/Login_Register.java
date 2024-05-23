package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Register extends JFrame implements ActionListener {
    private JButton loginButton;
    private JButton registerButton;
    private JButton exitButton;
    private JButton visitor;

    public Login_Register() {
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(750,400);
        setTitle("登录/注册");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        loginButton = new JButton("登录");
        registerButton = new JButton("注册");
        exitButton = new JButton("退出");
        visitor=new JButton("访客");

        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
           new  login();
        } else if (e.getSource() == registerButton) {
            new register();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login_Register();
    }
}