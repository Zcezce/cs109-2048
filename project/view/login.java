package view;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class login {
    private static String usersname = JOptionPane.showInputDialog("Enter your name");
    private static String code = JOptionPane.showInputDialog("Enter your code");

    public String getUsersname() {
        return usersname;
    }

    public String getCode() {
        return code;
    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader=new FileReader("C:\\Users\\86187\\Desktop\\src\\store.txt");
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line;
        while ((line=bufferedReader.readLine())!=null){
            String[] arr=line.split("\\s");
           if(Objects.equals(arr[0], usersname)){//用户名
               if(Objects.equals(arr[1], code)){//密码
                   System.out.print("登录成功");
                   GameFrame gui = new GameFrame(500,500);
                   gui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                   gui.setSize(800, 600);
                   gui.setVisible(true);
                   new Login_Register();
                   break;
               }else JOptionPane.showMessageDialog(null,"密码错误");
           }
        }
    }
}
