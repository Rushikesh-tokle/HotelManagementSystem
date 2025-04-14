package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel room_lbl,checkin_t,checkout_t;
    JButton checkout,back;
    ResultSet rs;

    CheckOut(){
        setLayout(null);
        setBounds(300,200,780,500);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("CHECKOUT");
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        heading.setBounds(20,20,350,25);
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblid=new JLabel("CUSTOMER ID");
        lblid.setBounds(30,80,110,25);
        add(lblid);
        ccustomer=new Choice();
        ccustomer.setBounds(150,80,180,25);
        add(ccustomer);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(330,80,25,25);
        add(image);

        JLabel lblroom=new JLabel("ROOM NUMBER");
        lblroom.setBounds(30,110,100,25);
        add(lblroom);
        room_lbl=new JLabel();
        room_lbl.setBounds(150,110,180,25);
        add(room_lbl);

        JLabel lblcheckin=new JLabel("CHECK-IN-TIME");
        lblcheckin.setBounds(30,145,100,25);
        add(lblcheckin);
        checkin_t=new JLabel();
        checkin_t.setBounds(150,145,180,25);
        add(checkin_t);

        JLabel lblcheckout=new JLabel("CHECK-OUT-TIME");
        lblcheckout.setBounds(30,180,130,25);
        add(lblcheckout);
        Date dt=new Date();
        checkout_t=new JLabel("" +dt);
        checkout_t.setBounds(150,180,180,25);
        add(checkout_t);

        checkout=new JButton("CHECKOUT");
        checkout.setBounds(30,215,120,25);
        checkout.addActionListener(this);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);

        back=new JButton("BACK");
        back.setBounds(160,215,120,25);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        try {
            Conn c=new Conn();
            rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("id_numb"));
                room_lbl.setText(rs.getString("room"));
                checkin_t.setText(rs.getString("time"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(380,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(370,80,380,250);
        add(image2);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkout){

         String query1="delete from customer where id_numb='"+ccustomer.getSelectedItem()+"'";
         String query2="update rooms set availability='AVAILABLE' where roomno='"+room_lbl.getText()+"'";
         try{
             Conn c=new Conn();
             c.s.executeUpdate(query1);
             c.s.executeUpdate(query2);
             JOptionPane.showMessageDialog(null,"CHECKOUT SUCCESSFULL");
             setVisible(false);
         }catch (Exception e){
             e.printStackTrace();
         }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Reception();
        }

    }
    public static void main(String[] args) {
        new CheckOut();
    }
}
