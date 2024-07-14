import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class BoardingPass extends JFrame implements ActionListener{


    JTextField tfpnr;
    JLabel tfname, tfnationality, tfsrc, tfdest, tffname, tffcode, tfdate;
    JButton details;

    public BoardingPass(){


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);



        //
        JLabel heading = new JLabel("NIVI INDIA");
        heading.setForeground(Color.BLACK);
        heading.setBounds(340,10,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN, 16));
        add(heading);   

        JLabel heading1 = new JLabel("Boarding Pass");
        heading1.setForeground(Color.BLACK);
        heading1.setBounds(330,50,500,35);
        heading1.setFont(new Font("Tahoma",Font.PLAIN, 16));
        add(heading1); 


        //
        JLabel lblaadhar = new JLabel("PNR DETAILS");
        lblaadhar.setBounds(50,100,150,25);
        lblaadhar.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lblaadhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(200,100,150,25);
        add(tfpnr);


        //
        details = new JButton("Enter");
        details.setBounds(360,  100,120,25);
        details.setForeground(Color.WHITE);
        details.setBackground(Color.BLACK);
        details.addActionListener(this);
        add(details);



        //
        //
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(50,150,150,25);
        lblname.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lblname);

        //
        tfname = new JLabel();
        tfname.setBounds(200,150,150,25);
        add(tfname);



        //
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(50,200,150,25);
        lblnationality.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lblnationality);

        //
        tfnationality = new JLabel();
        tfnationality.setBounds(200,200,150,25);
        add(tfnationality);



        //
        JLabel lblsrc = new JLabel("SRC");
        lblsrc.setBounds(50,250,150,25);
        lblsrc.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lblsrc);

        //
        tfsrc = new JLabel();
        tfsrc.setBounds(200,250,150,25);
        add(tfsrc);



        //
        JLabel lbldest = new JLabel("DEST");
        lbldest.setBounds(360,250,150,25);
        lbldest.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbldest);

        //
        tfdest = new JLabel();
        tfdest.setBounds(410,250,150,25);
        add(tfdest);



        //
        JLabel lblfname = new JLabel("FLIGHT NAME");
        lblfname.setBounds(50,300,150,25);
        lblfname.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lblfname);

        //
        tffname = new JLabel();
        tffname.setBounds(200,300,150,25);
        add(tffname);



        //
        //
        JLabel lblfcode = new JLabel("FLIGHT CODE");
        lblfcode.setBounds(360,300,150,25);
        lblfcode.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lblfcode);

        //
        tffcode = new JLabel();
        tffcode.setBounds(410,300,150,25);
        add(tffcode);



        //
        JLabel lbldate = new JLabel("DATE");
        lbldate.setBounds(50,350,150,25);
        lbldate.setFont(new Font("TAHOMA", Font.PLAIN,18));
        add(lbldate);

        //
        tfdate = new JLabel();
        tfdate.setBounds(200,350,150,25);
        add(tfdate);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,250,250);
        add(image);



        setBounds(200,150,800,450);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == details){
            String pnr = tfpnr.getText();

            try{

                Conn c = new Conn();
                String query = "select * from reservation where PNR = '"+pnr+"'";
                
                ResultSet rs = c.s.executeQuery(query);


                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfsrc.setText(rs.getString("source"));
                    tfdest.setText(rs.getString("destination"));
                    tffname.setText(rs.getString("flightname"));
                    tffcode.setText(rs.getString("flightcode"));
                    tfdate.setText(rs.getString("date"));

                }else{
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR");
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String...vr){

        new BoardingPass();

    }
    
}
