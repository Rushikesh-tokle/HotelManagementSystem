package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField name_t,age_t,salery_t,email_t,phone_t,adhar_t;
    JRadioButton male ,female;
    JButton submit;
    JComboBox cbjob;
    AddEmployee(){
        setLayout(null);
      setSize(1000,600);
      setLocation(200,200);
     getContentPane().setBackground(Color.WHITE);

     JLabel addE=new JLabel("ADD EMPLOYEE");
     addE.setBounds(365,10,500,45);
     addE.setFont(new Font("Tahoma",Font.BOLD,44));
     add(addE);

      JLabel name=new JLabel("NAME");
      name.setBounds(20,60,50,30);
      add(name);
       name_t=new JTextField();
      name_t.setBounds(80,60,200,30);
      add(name_t);

      JLabel age=new JLabel("AGE");
      age.setBounds(20,100,50,30);
      add(age);
       age_t=new JTextField();
      age_t.setBounds(80,100,200,30);
      add(age_t);

      JLabel gender=new JLabel("GENDER");
      gender.setBounds(20,140,70,30);
      add(gender);
       male=new JRadioButton("MALE");
      male.setBounds(90,140,70,30);
      male.setBackground(Color.WHITE);
      add(male);
       female=new JRadioButton("FEMALE");
      female.setBounds(170,140,100,30);
      female.setBackground(Color.WHITE);
      add(female);
      ButtonGroup bg=new ButtonGroup();
      bg.add(male);
      bg.add(female);

      JLabel job=new JLabel("JOB");
      job.setBounds(20,180,50,30);
      add(job);

      String[]str={"WAITER","DRIVER","CHEF","DESK CLERK","ROOM SERVICE","MANAGER","ACCOUNTANT"};
      cbjob=new JComboBox(str);
      cbjob.setBackground(Color.WHITE);
      cbjob.setBounds(80,180,200,30);
      add(cbjob);

        JLabel salery=new JLabel("SALERY");
        salery.setBounds(20,220,50,30);
        add(salery);
         salery_t=new JTextField();
        salery_t.setBounds(80,220,200,30);
        add(salery_t);

        JLabel phone=new JLabel("PHONE");
        phone.setBounds(20,260,50,30);
        add(phone);
       phone_t=new JTextField();
        phone_t.setBounds(80,260,200,30);
        add(phone_t);

        JLabel email=new JLabel("EMAIL");
        email.setBounds(20,300,50,30);
        add(email);
        email_t=new JTextField();
        email_t.setBounds(80,300,200,30);
        add(email_t);

        JLabel adhar=new JLabel("AADHAR");
        adhar.setBounds(20,340,50,30);
        add(adhar);
         adhar_t=new JTextField();
        adhar_t.setBounds(80,340,200,30);
        add(adhar_t);

         submit=new JButton("SUBMIT");
        submit.setBounds(80,380,100,35);
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(300,50,500,400);
        add(image);
      setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String name=name_t.getText();
        String age=age_t.getText();
        String salery=salery_t.getText();
        String email=email_t.getText();
        String phone=phone_t.getText();
        String adhar=adhar_t.getText();

        String gender=null;
//Validation Validation Validation Name
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"name cannot be empty");
            return;
        } else if (!name.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(null,"NAME MUST  CONTAIN ONLY LETTER AND SPACES");
        }
//AGE
        if(age.equals("")){
            JOptionPane.showMessageDialog(null,"AGE CANNOT BE NULL");
            return;
        }
        try{
            int ageValue=Integer.parseInt(age);
            if(ageValue<18 || ageValue>80){
                JOptionPane.showMessageDialog(null,"AGE MUST BE BETWEEN 18-80");
                return;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"ENTER A VALID AGE");
            return;
        }
// Select Gender
        if((!male.isSelected()) && (!female.isSelected())){
            JOptionPane.showMessageDialog(null,"SELECT YOUR GENDER");
            return;
        }
        if(male.isSelected()){
            gender="male";
        }
        else {
            gender="female";
        }

        String job=(String) cbjob.getSelectedItem();
//Salary
        if(salery.equals("")){
            JOptionPane.showMessageDialog(null,"ENTER THE EMPLOYEE SALERY");
            return;
        }
        try{
            int saleryVal=Integer.parseInt(salery);
            if(saleryVal<0){
                JOptionPane.showMessageDialog(null,"ENTER A VALID SALERY");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"ENTER A VALID SALERY");
            return;
        }
//PHONE
        if (phone.equals("")) {
            JOptionPane.showMessageDialog(null, "ENTER YOUR PHONE NUMBER");
            return;
        }

// Check if it's a valid Indian number (starts with 6-9 and is 10 digits)
        if (!phone.matches("^[6-9]\\d{9}$")) {
            JOptionPane.showMessageDialog(null, "ENTER A VALID 10-DIGIT INDIAN PHONE NUMBER");
            return;
        }
//Email Validation
        if(email.equals("")){
            JOptionPane.showMessageDialog(null,"ENTER A VALID EMAIL");
            return;
        }
        if(!email.matches("^[A-Za-z0-9+_.-]+@gmail\\.com$")){
            JOptionPane.showMessageDialog(null,"ENTER A VALID EMAIL");
            return;
        }
//AADHAR VALIDATION
        if(adhar.equals("")){
            JOptionPane.showMessageDialog(null,"ENTER A VALID ADHAR NUMBER");
        }
        if (!adhar.matches("\\d{12}")) {
            JOptionPane.showMessageDialog(null, "ADHAR NUMBER MUST BE EXACTLY 12 DIGITS AND DIGITS ONLY");
            return;
        }
        try{
            Conn c=new Conn();
            String query="insert into employee values('"+name+"','"+age+"','"+salery+"','"+email+"','"+phone+"','"+adhar+"','"+gender+"','"+job+"')";
            c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"EMPLOYEE ADDED SUCCESSFULLY");
          setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[]args){
    new AddEmployee();
    }
}
