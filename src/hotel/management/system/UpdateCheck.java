package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField name_t,room_t,checkin_t,amount_t,pending_t;
    JButton check,update,back;
    UpdateCheck(){
        setLayout(null);
        setBounds(300,200,780,500);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("UPDATE STATUS");
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        heading.setBounds(20,20,350,25);
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblid=new JLabel("CUSTOMER ID");
        lblid.setBounds(20,90,110,20);
        add(lblid);
        ccustomer=new Choice();
        ccustomer.setBounds(140,90,150,25);
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
        lblroom.setBounds(30,120,100,20);
        add(lblroom);
        room_t=new JTextField();
        room_t.setBounds(140,120,150,20);
        add(room_t);

        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(30,150,100,20);
        add(lblname);
        name_t=new JTextField();
        name_t.setBounds(140,150,150,20);
        add(name_t);

        JLabel lblcheckin=new JLabel("CHECK-IN-TIME");
        lblcheckin.setBounds(30,180,100,20);
        add(lblcheckin);
        checkin_t=new JTextField();
        checkin_t.setBounds(140,180,150,20);
        add(checkin_t);

        JLabel lblamount=new JLabel("AMOUNT PAID");
        lblamount.setBounds(30,210,100,20);
        add(lblamount);
        amount_t=new JTextField();
        amount_t.setBounds(140,210,150,20);
        add(amount_t);

        JLabel lblpending=new JLabel("PENDING AMA.");
        lblpending.setBounds(30,240,100,20);
        add(lblpending);
        pending_t=new JTextField();
        pending_t.setBounds(140,240,150,20);
        add(pending_t);

        check=new JButton("CHECK");
        check.setBounds(30,270,90,20);
        check.addActionListener(this);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        add(check);

        update=new JButton("UPDATE");
        update.setBounds(130,270,90,20);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

        back=new JButton("BACK");
        back.setBounds(230,270,90,20);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        Image i2=i1.getImage().getScaledInstance(340,340,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,340,340);
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
               name_t.setText(rs.getString("name"));
               checkin_t.setText(rs.getString("time"));
               amount_t.setText(rs.getString("deposit"));
           }
           ResultSet rs2=c.s.executeQuery("select * from rooms where roomno='"+room_t.getText()+"'");
           while (rs2.next()){
               String price=rs2.getString("price");
               int amountPaid=Integer.parseInt(price)-Integer.parseInt(amount_t.getText());
               pending_t.setText(""+amountPaid);
           }
          }catch (Exception e){
              e.printStackTrace();
          }

      } else if (ae.getSource()==update) {
        String number=ccustomer.getSelectedItem();
        String room=room_t.getText();
        String name= name_t.getText();
        String check=checkin_t.getText();
        String depo=amount_t.getText();
        try{
          Conn c=new Conn();
          c.s.executeUpdate("update customer set room='"+room+"',name='"+name+"',time='"+check+"',deposit='"+depo+"' where id_numb='"+number+"'");
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
        new UpdateCheck();
    }
}
