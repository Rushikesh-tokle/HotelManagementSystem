package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    Choice carTypeC;
    JCheckBox jcb;
    PickUp(){
        setLayout(null);
        setBounds(300,200,950,600);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("PICKUP SERVICE");
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        heading.setBounds(400,10,300,30);
        add(heading);

        JLabel carType=new JLabel("CAR TYPE");
        carType.setBounds(40,100,110,20);
        add(carType);
        carTypeC =new Choice();
        carTypeC.setBounds(150,100,200,25);
        add(carTypeC);
         try{
             Conn c=new Conn();
             ResultSet rs=c.s.executeQuery("select * from driver");
             while (rs.next()){
                 carTypeC.add(rs.getString("company"));

             }
         }catch (Exception e)
         {
             e.printStackTrace();
         }

        JLabel l1=new JLabel("Room Number");
        l1.setBounds(40,150,110,20);
        add(l1);
        JLabel l2=new JLabel("Availability");
        l2.setBounds(190,150,100,20);
        add(l2);
        JLabel lg=new JLabel("Gender");
        lg.setBounds(330,150,100,20);
        add(lg);
        JLabel l3=new JLabel("Status");
        l3.setBounds(470,150,80,20);
        add(l3);
        JLabel l4=new JLabel("Car-type");
        l4.setBounds(630,150,250,20);
        add(l4);
        JLabel l5=new JLabel("location");
        l5.setBounds(770,150,150,20);
        add(l5);

        table=new JTable();
        table.setBounds(0,180,900,200);
        add(table);

        try{
            Conn c=new Conn();
            ResultSet rs2=c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs2));
        }catch (Exception e){
            e.printStackTrace();
        }


        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420,450,120,30);
        add(back);

        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(120,450,120,30);
        add(submit);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit) {
            try{
               String query="select * from driver where company='"+carTypeC.getSelectedItem()+"'";
               Conn c=new Conn();
                ResultSet rs;
               rs=c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new PickUp();
    }
}
