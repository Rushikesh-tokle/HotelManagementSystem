package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {

    JButton newCustForm;
    Reception(){
        setLayout(null);
        setBounds(180,180,1050,630);
        getContentPane().setBackground(Color.WHITE);

        newCustForm=new JButton("NEW CUSTOMER FORM");
        newCustForm.setBounds(50,25,200,35);
        newCustForm.addActionListener(this);
        newCustForm.setBackground(Color.BLACK);
        newCustForm.setForeground(Color.WHITE);
        add(newCustForm);

        JButton rooms=new JButton("ROOMS");
        rooms.setBounds(50,70,200,35);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        add(rooms);

        JButton department=new JButton("DEPARTMENT");
        department.setBounds(50,115,200,35);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        add(department);

        JButton allEmployees=new JButton("ALL EMPLOYEES");
        allEmployees.setBounds(50,160,200,35);
        allEmployees.setBackground(Color.BLACK);
        allEmployees.setForeground(Color.WHITE);
        add(allEmployees);

        JButton customerInfo=new JButton("CUSTOMER INFO");
        customerInfo.setBounds(50,205,200,35);
        customerInfo.setBackground(Color.BLACK);
        customerInfo.setForeground(Color.WHITE);
        add(customerInfo);

        JButton managerInfo=new JButton("MANAGER INFO");
        managerInfo.setBounds(50,250,200,35);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        add(managerInfo);

        JButton checkout=new JButton("CHECKOUTS");
        checkout.setBounds(50,295,200,35);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);

        JButton updateStatus=new JButton("UPDATE STATUS");
        updateStatus.setBounds(50,340,200,35);
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        add(updateStatus);

        JButton updateRoomStatus=new JButton("UPDATE ROOM STATUS");
        updateRoomStatus.setBounds(50,385,200,35);
        updateRoomStatus.setBackground(Color.BLACK);
        updateRoomStatus.setForeground(Color.WHITE);
        add(updateRoomStatus);

        JButton pickupServices=new JButton("PICKUP SERVICES");
        pickupServices.setBounds(50,430,200,35);
        pickupServices.setBackground(Color.BLACK);
        pickupServices.setForeground(Color.WHITE);
        add(pickupServices);

        JButton searchRooms=new JButton("SEARCH ROOMS");
        searchRooms.setBounds(50,475,200,35);
        searchRooms.setBackground(Color.BLACK);
        searchRooms.setForeground(Color.WHITE);
        add(searchRooms);

        JButton logout=new JButton("LOGOUT");
        logout.setBounds(50,520,200,35);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2=i1.getImage().getScaledInstance(520,520,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(300,25,520,520);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==newCustForm){
           new AddCustomer();
       }
    }
    public static void main(String[]args){
      new Reception();
    }
}
