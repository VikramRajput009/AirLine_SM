import java.awt.Color;

import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;



public class Login extends JFrame implements ActionListener{

    JButton reset, submit, close;
    JPasswordField tfpassword;
    JTextField tfusername;

    public Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20,40,100,20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(130,40,100,20);
        add(tfusername);



        //
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20,80,100,20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(130,80,100,20);
        add(tfpassword);


        //
        reset = new JButton("Reset");
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.setBounds(40,160,80,20);
        reset.addActionListener(this);
        add(reset);


        //
        //
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(160,160,80,20);
        submit.addActionListener(this);
        add(submit);


        //
        //
        close = new JButton("Close");
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);
        close.setBounds(280,160,80,20);
        close.addActionListener(this);
        add(close);



        setBounds(600,250,500,250);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == submit){

            String username = tfusername.getText();
            String password = tfpassword.getText();

            try{

                Conn c = new Conn();

                String query = "select * from login where username = '"+ username +"' and password = '"+ password +"'";

                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    new Home();
                    setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);

                }

            }catch(Exception e){
                e.printStackTrace();
            }



        }else if(ae.getSource() == reset){
            tfusername.setText("");
            tfpassword.setText("");


        }else if(ae.getSource() == close){
            setVisible(false);
        }

    }

    public static void main(String...vr){
        new Login();

    }
}