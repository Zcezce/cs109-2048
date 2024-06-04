package view;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class register  {
    private static String filepath="C:\\Users\\86187\\Desktop\\src\\store.txt";

    public static String getFilepath() {
        return filepath;
    }

    private JFrame Login=new JFrame("注册界面");
    private TextField usersName=new TextField(1);
   private  TextField code=new TextField(1);
    private JButton ok=new JButton("ok");
    static Font font = new Font("Serif", Font.BOLD, 42);
    public static void fileWriter(String filepath,String content)throws IOException {
        try (FileWriter fileWriter=new FileWriter(filepath,true)){
            fileWriter.write(content);
        }
    }

    public static void main(String[] args) {
        String usersname = JOptionPane.showInputDialog("Enter your name");
        String code = JOptionPane.showInputDialog("Enter your code");
        try {
            fileWriter(getFilepath(),usersname+" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter(getFilepath(),code);
            fileWriter(getFilepath(),"\r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JOptionPane.showMessageDialog(null, "register success");
    }

    }

