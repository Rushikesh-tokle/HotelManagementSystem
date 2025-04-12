
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
       setBounds(0,0,1550,1000);
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
       Image i2=i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel img=new JLabel(i3);
       img.setBounds(0,0,1550,1000);
       add(img);

       JLabel text=new JLabel("Taj Group Welcomes You!");
       text.setBounds(400,80,1000,50);
       text.setFont(new Font("Tahoma",Font.PLAIN,46));
       text.setForeground(Color.WHITE);
       img.add(text);

       JMenuBar mb=new JMenuBar();
       mb.setBounds(0,0,1550,30);
       img.add(mb);

       JMenu hotel=new JMenu("HOTEL MANAGEMENT");
       hotel.setForeground(Color.RED);
       mb.add(hotel);

       JMenuItem reception=new JMenuItem("RECEPTION");
      reception.addActionListener(this);
       hotel.add(reception);


       JMenu admin=new JMenu("ADMIN");
       admin.setForeground(Color.BLUE);
       mb.add(admin);

       JMenuItem addEmployee=new JMenuItem("ADD EMPLOYEE");
       addEmployee.addActionListener(this);
       admin.add(addEmployee);
       JMenuItem addRoom=new JMenuItem("ADD ROOMS");
       addRoom.addActionListener(this);
       admin.add(addRoom);
       JMenuItem addDriver=new JMenuItem("ADD DRIVER");
       addDriver.addActionListener(this);
       admin.add(addDriver);

       setVisible(true);

    }

    public void actionPerformed(ActionEvent a){
      if(a.getActionCommand().equals("ADD EMPLOYEE")){
         new AddEmployee();
      } else if (a.getActionCommand().equals("ADD ROOMS")) {
         new AddDrivers();
      } else if (a.getActionCommand().equals("ADD DRIVER")) {
          new AddDrivers();
      }else {
          new Reception();
      }
    }
    public static void main(String[]args){
        new Dashboard();
    }
}
