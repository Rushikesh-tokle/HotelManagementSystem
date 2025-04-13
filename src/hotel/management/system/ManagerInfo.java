package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    ManagerInfo(){
        setLayout(null);
        setBounds(300,200,1050,600);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1=new JLabel("name");
        l1.setBounds(40,10,110,20);
        add(l1);
        JLabel l2=new JLabel("age");
        l2.setBounds(150,10,40,20);
        add(l2);
        JLabel l3=new JLabel("salery");
        l3.setBounds(280,10,80,20);
        add(l3);
        JLabel l4=new JLabel("email");
        l4.setBounds(400,10,250,20);
        add(l4);
        JLabel l5=new JLabel("phone");
        l5.setBounds(510,10,150,20);
        add(l5);
        JLabel l6=new JLabel("adhar");
        l6.setBounds(635,10,200,20);
        add(l6);
        JLabel l7=new JLabel("gender");
        l7.setBounds(760,10,100,20);
        add(l7);
        JLabel l8=new JLabel("job role");
        l8.setBounds(900,10,150,20);
        add(l8);

        table=new JTable();
        table.setBounds(0,40,1000,400);
        add(table);

        try{
            Conn c=new Conn();
            String query="select * from employee where job='MANAGER'";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new ManagerInfo();
    }
}
