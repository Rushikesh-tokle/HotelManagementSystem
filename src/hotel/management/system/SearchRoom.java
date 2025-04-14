package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox jcb;
    SearchRoom(){
        setLayout(null);
        setBounds(300,200,950,600);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("Search For Room");
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        heading.setBounds(400,10,300,30);
        add(heading);

        JLabel lblroombedtype=new JLabel("Room Bed Type");
        lblroombedtype.setBounds(40,100,110,20);
        add(lblroombedtype);
        String []type={"SINGLE","DOUBLE"};
       bedtype=new JComboBox(type);
        bedtype.setBounds(150,100,110,20);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);

        jcb=new JCheckBox("display only available");
        jcb.setBounds(550,100,200,20);
        jcb.setBackground(Color.WHITE);
        add(jcb);

        JLabel l1=new JLabel("Room Number");
        l1.setBounds(40,150,110,20);
        add(l1);
        JLabel l2=new JLabel("Availability");
        l2.setBounds(225,150,100,20);
        add(l2);
        JLabel l3=new JLabel("Status");
        l3.setBounds(420,150,80,20);
        add(l3);
        JLabel l4=new JLabel("Price");
        l4.setBounds(600,150,250,20);
        add(l4);
        JLabel l5=new JLabel("bedtype");
        l5.setBounds(740,150,150,20);
        add(l5);

        table=new JTable();
        table.setBounds(0,180,900,200);
        add(table);


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
         String query="select * from rooms where bedtype='"+bedtype.getSelectedItem()+"'";
         String query1="select * from rooms where availability='AVAILABLE' AND  bedtype='"+bedtype.getSelectedItem()+"' ";
         Conn c=new Conn();
         if(jcb.isSelected()){
             ResultSet rs=c.s.executeQuery(query1);
             table.setModel(DbUtils.resultSetToTableModel(rs));
         }
         else {
             ResultSet rs=c.s.executeQuery(query);
             table.setModel(DbUtils.resultSetToTableModel(rs));
         }

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
