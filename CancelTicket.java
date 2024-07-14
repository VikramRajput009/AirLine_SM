import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import java.util.*;


public class CancelTicket extends JFrame implements ActionListener{

    JTextField tfpnr;
    JLabel tfname, tfcode, tfdate, tfcancellation;
    JButton details, cancel;

    public CancelTicket(){

        Random random = new Random();
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        //
        JLabel heading = new JLabel("CANCELLATION");
        heading.setForeground(Color.BLACK);
        heading.setBounds(300,10,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN, 16));
        add(heading);



        //
        JLabel lblaadhar = new JLabel("PNR Number");
        lblaadhar.setBounds(50,70,150,25);
        lblaadhar.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lblaadhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(200,70,150,25);
        add(tfpnr);


        //
        details = new JButton("Show Details");
        details.setBounds(360,70,120,25);
        details.setForeground(Color.WHITE);
        details.setBackground(Color.BLACK);
        details.addActionListener(this);
        add(details);



        //
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,120,150,25);
        lblname.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lblname);

        //
        tfname = new JLabel();
        tfname.setBounds(200,120,150,25);
        add(tfname);



        //
        JLabel lblcancellation = new JLabel("Cancellation No");
        lblcancellation.setBounds(50,170,150,25);
        lblcancellation.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lblcancellation);


        //
        tfcancellation = new JLabel("" + random.nextInt(1000000));
        tfcancellation.setBounds(200,170,150,25);
        add(tfcancellation);



        //
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(50,220,150,25);
        lblfcode.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lblfcode);

        //
        tfcode = new JLabel();
        tfcode.setBounds(200,220,150,25);
        add(tfcode);



        //
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(50,270,150,25);
        lbldate.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbldate);

        //
        tfdate= new JLabel();
        tfdate.setBounds(200,270,150,25);
        add(tfdate);




        //
        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,120,25);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);


        
        //
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470,120,250,250);
        add(image);


        
        setBounds(200,150,800,500);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == details){

            String pnr = tfpnr.getText();

            try{

                Conn c = new Conn();

                String query = "select  * from reservation where PNR = '"+ pnr +"'";

                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfcode.setText(rs.getString("flightcode"));
                    tfdate.setText(rs.getString("date"));
                }


            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == cancel){

            String pnr= tfpnr.getText();
            String name= tfname.getText();
            String cancellation = tfcancellation.getText();
            String fcode= tfcode.getText();
            String date= tfdate.getText();


            try{

                Conn c = new Conn();

                String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancellation+"','"+fcode+"','"+date+"')";

                c.s.executeUpdate(query);
                c.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");

                JOptionPane.showMessageDialog(null, "Ticket Cancel Successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    
    
    public static void main(String...vr){

        new CancelTicket();
    }
}
