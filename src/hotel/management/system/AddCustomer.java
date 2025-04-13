package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.sql.ResultSet;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField number,name,country,deposit;
    JComboBox idsect;
    JRadioButton male,female;
    JButton addCustomer,back;
    Choice croom;
    JLabel checkInTime;
    AddCustomer(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(200,200,800,500);

        JLabel heading=new JLabel("NEW CUSTOMER FORM");
        heading.setBounds(105,10,500,45);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel id=new JLabel("ID");
        id.setBounds(25,55,100,30);
        add(id);
        String idType[]={"PASSPORT","AADHAR","VOTOR ID","DRIVING LICENCE","RATION CARD"};
         idsect=new JComboBox(idType);
        idsect.setBounds(150,55,200,30);
        idsect.setBackground(Color.WHITE);
        add(idsect);

        JLabel numb=new JLabel("NUMBER");
        numb.setBounds(25,95,100,30);
        add(numb);
         number=new JTextField();
        number.setFont(new Font("Tahoma",Font.PLAIN,15));
        number.setBounds(150,95,200,30);
        add(number);

        JLabel name_l=new JLabel("NAME");
        name_l.setBounds(25,135,100,30);
        add(name_l);
        name=new JTextField();
        name.setFont(new Font("Tahoma",Font.PLAIN,15));
        name.setBounds(150,135,200,30);
        add(name);

        JLabel gend=new JLabel("GENDER");
        gend.setBounds(25,175,100,30);
        add(gend);
        male=new JRadioButton("MALE");
        male.setFont(new Font("Tahoma",Font.PLAIN,15));
        male.setBounds(150,175,80,30);
        male.setBackground(Color.WHITE);
        add(male);
        female=new JRadioButton("FEMALE");
        female.setFont(new Font("Tahoma",Font.PLAIN,15));
        female.setBounds(250,175,90,30);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel country_l=new JLabel("COUNTRY");
        country_l.setBounds(25,215,100,30);
        add(country_l);
        country=new JTextField();
        country.setFont(new Font("Tahoma",Font.PLAIN,15));
        country.setBounds(150,215,200,30);
        add(country);

        JLabel allotedRoom=new JLabel("ALLOTED ROOM");
        allotedRoom.setBounds(25,255,100,30);
        add(allotedRoom);
        croom=new Choice();
        try{
           Conn c=new Conn();
           String query="Select * from rooms where availability='AVAILABLE'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        croom.setFont(new Font("Tahoma",Font.PLAIN,15));
        croom.setBounds(150,255,200,30);
        croom.setBackground(Color.WHITE);
        add(croom);

        Date date=new Date();

        JLabel check=new JLabel("CHECK IN TIME");
        check.setBounds(25,295,100,30);
        add(check);
        checkInTime=new JLabel(" "+date);
        checkInTime.setBounds(150,295,240,30);
        checkInTime.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(checkInTime);



       JLabel depo=new JLabel("DEPOSIT");
        depo.setBounds(25,335,100,30);
        add(depo);
        deposit=new JTextField();
        deposit.setFont(new Font("Tahoma",Font.PLAIN,15));
        deposit.setBounds(150,335,200,30);
        add(deposit);

        addCustomer=new JButton("SUBMIT");
        addCustomer.setBounds(25,375,150,30);
        addCustomer.addActionListener(this);
        addCustomer.setBackground(Color.BLACK);
        addCustomer.setForeground(Color.WHITE);
        add(addCustomer);

        back=new JButton("BACK");
        back.setBounds(195,375,150,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,400,400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String id_ae=(String) idsect.getSelectedItem();
        String numbe_ae=number.getText();
        String name_ae=name.getText();
        String gender_ae=null;
        String country_ae=country.getText();
        String room_ae= croom.getSelectedItem();
        String time_ae=checkInTime.getText();
        String deposit_ae=deposit.getText();

        if(male.isSelected()){
            gender_ae="male";
        }
        else {
            gender_ae="female";
        }
          if(ae.getSource()==addCustomer){
              try {
                  Conn c = new Conn();
                  String query = "insert into customer values('" + id_ae + "','" + numbe_ae + "','" + name_ae + "','" + gender_ae + "','" + country_ae + "','" + room_ae + "','" + time_ae + "','" + deposit_ae + "')";
                  String query2="update rooms set availability='OCCUPIED' where roomno='"+room_ae+"' ";
                  c.s.executeUpdate(query);
                  c.s.executeUpdate(query2);
                  JOptionPane.showMessageDialog(null,"CUSTOMER INFO STORED SUCCESSFULL");
                 setVisible(false);
                  new Reception();
              }catch (Exception e){
                  e.printStackTrace();
                 JOptionPane.showMessageDialog(null,"ENTER CORRECT VALUES");
              }
          } else if (ae.getSource()==back) {
              setVisible(false);
              new Reception();
          }
    }
    public static void main(String[]args){
       new AddCustomer();
    }
}
