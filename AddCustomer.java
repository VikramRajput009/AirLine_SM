import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;


public class AddCustomer extends JFrame implements ActionListener{

    JRadioButton rbmale, rbfemale;
    JTextField tfname, tfnationality, tfaddress, tfphone, tfaadhar;
    JButton save;

    public AddCustomer(){

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setForeground(Color.BLACK);
        heading.setBounds(300,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN, 20));
        add(heading);


        //
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(50,80,150,25);
        lblname.setFont(new Font("TAHOMA", Font.PLAIN,17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,80,150,25);
        add(tfname);


        //
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(50,130,150,30);
        lblnationality.setFont(new Font("TAHOMA", Font.PLAIN,17));
        add(lblnationality);

        tfnationality = new JTextField();
        tfnationality.setBounds(200,130,150,30);
        add(tfnationality);


        //
        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(50,180,120,30);
        lbladdress.setFont(new Font("TAHOMA", Font.PLAIN,17));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,180,150,30);
        add(tfaddress);



        //
        JLabel lblaadhar = new JLabel("AADHAR NUMBER");
        lblaadhar.setBounds(50,230,200,30);
        lblaadhar.setFont(new Font("TAHOMA", Font.PLAIN,17));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,230,150,30);
        add(tfaadhar);


        //
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(50,280,120,30);
        lblgender.setFont(new Font("TAHOMA", Font.PLAIN,17));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,280,70,25);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale); 

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(270,280,70,25);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale); 


        //
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);



        //
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(50,330,150,25);
        lblphone.setFont(new Font("TAHOMA", Font.PLAIN,17));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200,330,150,25);
        add(tfphone);



        //
        save = new JButton("Submit");
        save.setBounds(200,450,150,30);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);

        save.addActionListener(this);
        add(save);



        //
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/emp.png"));
        // Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(450,80,280,400);
        add(image);




        setBounds(300,150,800,600);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){

        String name= tfname.getText();
        String nationality= tfnationality.getText();       
        String address= tfaddress.getText();
        String aadhar_number= tfaadhar.getText();
        String phone= tfphone.getText();
        

        String gender = null;

        if(rbmale.isSelected()){
            gender = "Male";
        }else if(rbfemale.isSelected()){
            gender = "Female";
        }


        try{
            Conn c = new Conn();

            String query = "insert into passenger values ('"+ name +"', '"+ nationality +"','"+ address +"','"+ aadhar_number +"','"+ phone +"', '"+ gender +"')";

           c.s.executeUpdate(query);


           JOptionPane.showMessageDialog(null,"Customer Deatils Added Successfully");
           setVisible(false);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String...vr){

        new AddCustomer();
    }
    
}
