package hotel.management.system;
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user=new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);

        JTextField username=new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel pass=new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        JTextField password=new JTextField();
        password.setBounds(150,70,150,30);
        add(password);

        JButton login=new JButton("Login");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(40,120,80,30);
        add(login);

        JButton cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(150,120,80,30);
        add(cancel);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);

      setBounds(500,200,600,300);
      setVisible(true);
    }
    public static void main(String[]args){
        new Login();
    }
}
