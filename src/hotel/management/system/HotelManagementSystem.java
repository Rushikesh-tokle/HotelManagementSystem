// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){
     setSize(1366,565);
     setLocation(100,100);
     setLayout(null);
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
     JLabel image=new JLabel(i1);
     image.setBounds(0,0,1366,565);
     add(image);

     JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
     text.setBounds(20,430,1000,100);
     image.add(text);
     text.setFont(new Font("serif",Font.PLAIN,50));
     text.setForeground(Color.WHITE);


     JButton next=new JButton("NEXT");
     next.setBounds(1150,450,150,50);
     next.setBackground(Color.BLACK);
     next.setForeground(Color.WHITE);
     image.add(next);
     next.addActionListener(this);
     next.setFont(new Font("serif",Font.PLAIN,30));
     setVisible(true);

     while(true){
      text.setVisible(false);
      try {
       Thread.sleep(5000);
      }
      catch (Exception e){
       e.printStackTrace();
      }
      text.setVisible(true);
      try {
       Thread.sleep(5000);
      }
      catch (Exception e){
       e.printStackTrace();
      }
     }
    }

    public void actionPerformed(ActionEvent e){
     setVisible(false);
     new Login();
    }
    public static void main(String[] args) {
     new HotelManagementSystem();
    }
}