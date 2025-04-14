package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField name_availt,room_t, clean_status,amount_t;
    JButton check,update,back;
    UpdateRoom(){
        setLayout(null);
        setBounds(300,200,780,400);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("UPDATE ROOM STATUS");
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setBounds(30,20,350,30);
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblid=new JLabel("CUSTOMER ID");
        lblid.setBounds(20,90,110,30);
        add(lblid);
        ccustomer=new Choice();
        ccustomer.setBounds(140,90,150,30);
        add(ccustomer);

        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("id_numb"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel lblroom=new JLabel("ROOM NUMBER");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        room_t=new JTextField();
        room_t.setBounds(140,130,150,30);
        add(room_t);

        JLabel lblname=new JLabel("AVAILABILITY");
        lblname.setBounds(30,170,100,30);
        add(lblname);
        name_availt =new JTextField();
        name_availt.setBounds(140,170,150,30);
        add(name_availt);

        JLabel lblcheckin=new JLabel("CLEANING STATUS");
        lblcheckin.setBounds(30,210,100,30);
        add(lblcheckin);
        clean_status =new JTextField();
        clean_status.setBounds(140,210,150,30);
        add(clean_status);

        check=new JButton("CHECK");
        check.setBounds(30,250,90,30);
        check.addActionListener(this);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        add(check);

        update=new JButton("UPDATE");
        update.setBounds(130,250,90,30);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

        back=new JButton("BACK");
        back.setBounds(230,250,90,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(340,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,340,250);
        add(image);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==check){
            String id=ccustomer.getSelectedItem();
            String query="select * from customer where id_numb='"+id+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while (rs.next()){
                    room_t.setText(rs.getString("room"));
                 }
                ResultSet rs2=c.s.executeQuery("select * from rooms where roomno='"+room_t.getText()+"'");
                while (rs2.next()){
                  name_availt.setText(rs2.getString("availability"));
                  clean_status.setText(rs2.getString("status"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==update) {
            String number=ccustomer.getSelectedItem();
            String room=room_t.getText();
            String available= name_availt.getText();
            String clean_st= clean_status.getText();
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update rooms set availability='"+available+"',status='"+clean_st+"' where roomno='"+room+"'");
                JOptionPane.showMessageDialog(null,"DATA UPDATED SUCCESSFULLY");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new UpdateRoom();
    }
}
