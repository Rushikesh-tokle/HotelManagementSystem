package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame implements ActionListener {
    JButton addD,cancel;
    JTextField tfname,tfage, tftype,tfLocation;
    JComboBox driverCombo,genderCombo;
    AddDrivers(){
        setBounds(200,200,940,470);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        JLabel heading=new JLabel("ADD DRIVER");
        heading.setFont(new Font("TAHOMA",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel lblroomno=new JLabel("NAME");
        lblroomno.setFont(new Font("TAHOMA",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,20);
        add(lblroomno);
        tfname=new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);

        JLabel lblage=new JLabel("AGE");
        lblage.setFont(new Font("TAHOMA",Font.PLAIN,16));
        lblage.setBounds(60,130,120,30);
        add( lblage);
        tfage=new JTextField();
        tfage.setBounds(200,130,150,30);
        add(tfage);



        JLabel lblgender=new JLabel("GENDER");
        lblgender.setFont(new Font("TAHOMA",Font.PLAIN,16));
        lblgender.setBounds(60,180,120,30);
        add(lblgender);
        String cleanOptions[]={"MALE","FEMALE"};
        genderCombo=new JComboBox(cleanOptions);
        genderCombo.setBounds(200,180,150,30);
        genderCombo.setBackground(Color.WHITE);
        add(genderCombo);

        JLabel lblmodel=new JLabel("CAR COMPANY");
        lblmodel.setFont(new Font("TAHOMA",Font.PLAIN,16));
        lblmodel.setBounds(60,230,120,30);
        add(lblmodel);
        tftype =new JTextField();
        tftype.setBounds(200,230,150,30);
        add(tftype);

        JLabel lblavailable=new JLabel("AVAILABLE");
        lblavailable.setFont(new Font("TAHOMA",Font.PLAIN,16));
        lblavailable.setBounds(60,280,120,30);
        add(lblavailable);
        String driverOptions[]={"AVAILABLE","UNAVAILABLE"};
        driverCombo=new JComboBox(driverOptions);
        driverCombo.setBounds(200,280,150,30);
        driverCombo.setBackground(Color.WHITE);
        add(driverCombo);

        JLabel location=new JLabel("LOCATION");
        location.setFont(new Font("TAHOMA",Font.PLAIN,16));
        location.setBounds(60,330,120,30);
        add(location);
        tfLocation =new JTextField();
        tfLocation.setBounds(200,330,150,30);
        add(tfLocation);



        addD =new JButton("ADD DRIVER");
        addD.setForeground(Color.WHITE);
        addD.setBackground(Color.BLACK);
        addD.addActionListener(this);
        addD.setBounds(60,380,130,30);
        add(addD);

        cancel=new JButton("CANCEL");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setBounds(220,380,130,30);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addD) {
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String)genderCombo.getSelectedItem();
            String availability=(String)driverCombo.getSelectedItem();
            String company=tftype.getText();
            String location=tfLocation.getText();

            try {
                Conn c = new Conn();
                String query = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+availability+"','"+company+"','"+location+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"NEW DRIVER ADDED SUCCESSFULLY");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }
    public static void main(String[]args){
        new AddDrivers();

    }
}
