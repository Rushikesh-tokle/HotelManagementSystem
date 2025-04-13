package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JButton addR,cancel;
    JTextField tfroom,tfprice;
    JComboBox availableCombo,cleanCombo,bedCombo;
    AddRooms(){
     setBounds(200,200,940,470);
     setLayout(null);
     getContentPane().setBackground(Color.WHITE);


     JLabel heading=new JLabel("ADD ROOMS");
     heading.setFont(new Font("TAHOMA",Font.BOLD,18));
     heading.setBounds(150,20,200,20);
     add(heading);

        JLabel lblroomno=new JLabel("ROOM NO");
        lblroomno.setFont(new Font("TAHOMA",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,20);
        add(lblroomno);
         tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        JLabel lblavailable=new JLabel("AVAILABILITY");
        lblavailable.setFont(new Font("TAHOMA",Font.PLAIN,16));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);
        String availableOptions[]={"AVAILABLE","OCCUPIED"};
         availableCombo=new JComboBox(availableOptions);
        availableCombo.setBounds(200,130,150,30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        JLabel lblclean=new JLabel("CLEAN STATUS");
        lblclean.setFont(new Font("TAHOMA",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);
        String cleanOptions[]={"CLEAN","DIRTY"};
        cleanCombo=new JComboBox(cleanOptions);
        cleanCombo.setBounds(200,180,150,30);
        cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);

        JLabel lblprice=new JLabel("PRICE");
        lblprice.setFont(new Font("TAHOMA",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);
        tfprice=new JTextField();
       tfprice.setBounds(200,230,150,30);
       add(tfprice);

        JLabel lblbedtype=new JLabel("BED TYPE");
        lblbedtype.setFont(new Font("TAHOMA",Font.PLAIN,16));
        lblbedtype.setBounds(60,280,120,30);
        add(lblbedtype);
        String bedOptions[]={"SINGLE","DOUBLE"};
         bedCombo=new JComboBox(bedOptions);
        bedCombo.setBounds(200,280,150,30);
        bedCombo.setBackground(Color.WHITE);
        add(bedCombo);

        addR=new JButton("ADD ROOM");
       addR.setForeground(Color.WHITE);
       addR.setBackground(Color.BLACK);
       addR.addActionListener(this);
       addR.setBounds(60,350,130,30);
       add(addR);

         cancel=new JButton("CANCEl");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setBounds(220,350,130,30);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){

     if(ae.getSource()==addR) {
         String roomnumber=tfroom.getText();
         String availability=(String)availableCombo.getSelectedItem();
         String status=(String)cleanCombo.getSelectedItem();
         String price=tfprice.getText();
         String bedType=(String)bedCombo.getSelectedItem();

         try {
             Conn c = new Conn();
             String query = "insert into rooms values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+bedType+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"NEW ROOM ADDED SUCCESSFULLY");
             setVisible(false);
         }catch (Exception e){
          e.printStackTrace();
         }
     } else if (ae.getSource()==cancel) {
         setVisible(false);
     }
    }
    public static void main(String[]agrs){
    new AddRooms();
    }
}
