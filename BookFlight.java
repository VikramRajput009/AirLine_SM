import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.*;

public class BookFlight extends JFrame implements ActionListener{

    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress, tfgender, tffname, tffcode;
    JButton fetchButton , fetchButtonf, bookflight;
    Choice source, destination; 
    JDateChooser dcdate;



    public BookFlight(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);



        //
        JLabel heading = new JLabel("BOOK FLIGHT");
        heading.setForeground(Color.BLACK);
        heading.setBounds(500,10,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN, 16));
        add(heading);



        //
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(50,70,150,25);
        lblaadhar.setFont(new Font("TAHOMA", Font.PLAIN,14));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,70,150,25);
        add(tfaadhar);


        //
        fetchButton = new JButton("Fetch User");
        fetchButton.setBounds(360,70,120,25);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBackground(Color.BLACK);
        fetchButton.addActionListener(this);
        add(fetchButton);




        //
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,110,150,25);
        lblname.setFont(new Font("TAHOMA", Font.PLAIN,14));
        add(lblname);

        //
        tfname = new JLabel();
        tfname.setBounds(200,110,150,25);
        add(tfname);
        


        //
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(50,150,150,25);
        lblnationality.setFont(new Font("TAHOMA", Font.PLAIN,14));
        add(lblnationality);

        //
        tfnationality = new JLabel();
        tfnationality.setBounds(200,150,150,25);
        add(tfnationality);



        //
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,190,150,25);
        lbladdress.setFont(new Font("TAHOMA", Font.PLAIN,14));
        add(lbladdress);

        //
        tfaddress = new JLabel();
        tfaddress.setBounds(200,190,150,25);
        add(tfaddress);



        //
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(50,230,150,25);
        lblgender.setFont(new Font("TAHOMA", Font.PLAIN,14));
        add(lblgender);

        //
        tfgender = new JLabel();
        tfgender.setBounds(200,230,150,25);
        add(tfgender);



        //
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(50,270,150,25);
        lblsource.setFont(new Font("TAHOMA", Font.PLAIN,14));
        add(lblsource);

        //
        source = new Choice();
        source.setBounds(200,270,150,25);
        add(source);



        //
        JLabel lbldestination = new JLabel("Destination");
        lbldestination.setBounds(50,310,150,25);
        lbldestination.setFont(new Font("TAHOMA", Font.PLAIN,14));
        add(lbldestination);

        //
        destination = new Choice();
        destination.setBounds(200,310,150,25);
        add(destination);


        try{
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }



        //
        fetchButtonf = new JButton("Fetch Flights");
        fetchButtonf.setBounds(360,310,120,25);
        fetchButtonf.setForeground(Color.WHITE);
        fetchButtonf.setBackground(Color.BLACK);
        fetchButtonf.addActionListener(this);
        add(fetchButtonf);




        //
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(50,350,150,25);
        lblfname.setFont(new Font("TAHOMA", Font.PLAIN,14));
        add(lblfname);

        //
        tffname = new JLabel();
        tffname.setBounds(200,350,150,25);
        add(tffname);



        //
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(50,390,150,25);
        lblfcode.setFont(new Font("TAHOMA", Font.PLAIN,14));
        add(lblfcode);
        
        //
        tffcode = new JLabel();
        tffcode.setBounds(200,390,150,25);
        add(tffcode);



        //
        JLabel lbldotravel = new JLabel("Date Of Travel");
        lbldotravel.setBounds(50,430,150,25);
        lbldotravel.setFont(new Font("TAHOMA", Font.PLAIN,14));
        add(lbldotravel);

        //
        dcdate = new JDateChooser();
        dcdate.setBounds(200,430,150,25);
        dcdate.setForeground(Color.WHITE);
        add(dcdate);


        //
        bookflight = new JButton("Book Flight");
        bookflight.setBounds(200,490,120,25);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBackground(Color.BLACK);
        bookflight.addActionListener(this);
        add(bookflight);


        //
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,320,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,80,500,400);
        add(image);



        setBounds(200,150,1100,600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){     

        if(ae.getSource() == fetchButton){
            String aadhar = tfaadhar.getText();

            try{

                Conn c = new Conn();

                String query = "select * from passenger where aadhar_number = '"+ aadhar +"'";

                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfaddress.setText(rs.getString("address"));
                    tfgender.setText(rs.getString("gender"));
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
                }

            }catch(Exception e){
                e.printStackTrace();
            }


        }else if(ae.getSource() == fetchButtonf){
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();


            try{

                Conn c = new Conn();

                String query = "select * from flight where source = '"+ src +"' and destination = '"+ dest +"'";

                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    tffname.setText(rs.getString("f_name"));
                    tffcode.setText(rs.getString("f_code"));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "No Flights found");
                }

            }catch(Exception e){
                e.printStackTrace();
            }

        }else{


            Random random = new Random();

            String aadhar = tfaadhar.getText();
            String name = tfname.getText();
            String nationality = tfnationality.getText();
            String flightname = tffname.getText();
            String flightcode = tffcode.getText();
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();



            try{

                Conn c = new Conn();

                String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+ aadhar +"', '"+ name +"','"+ nationality +"', '"+ flightname +"', '"+ flightcode +"', '"+ src +"', '"+ dest +"', '"+ ddate +"')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");

                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String...vr){   

        new BookFlight();

    }
    
}
