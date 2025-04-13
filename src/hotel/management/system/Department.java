package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department(){
        setLayout(null);
        setBounds(300,200,1050,600);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1=new JLabel("department");
        l1.setBounds(180,10,100,20);
        add(l1);
        JLabel l2=new JLabel("Budget");
        l2.setBounds(470,10,100,20);
        add(l2);

        table=new JTable();
        table.setBounds(0,50,700,400);
        add(table);

        try{
            Conn c=new Conn();
            String query="select * from department";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
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
        new Department();
    }
}
