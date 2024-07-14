import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Home extends JFrame implements ActionListener{

    JMenuItem flightDetails, customerDetails, bookFlight, journeyDetail, ticketcancellation;

    public Home(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);


        //
        JLabel heading = new JLabel("NIVI INDIA WELCOMES YOU");
        heading.setForeground(Color.WHITE);
        heading.setBounds(500,20,700,70);
        heading.setFont(new Font("Tahoma",Font.PLAIN, 36));
        image.add(heading);



        // Menu Bar
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu details = new JMenu("DETAILS");
        details.setForeground(Color.BLACK);
        mb.add(details);

        //MENU ITEM = CLASS for the DROPDOWN  added in menu   
        // menu in MENUBAR
        flightDetails = new JMenuItem("FLIGHT DETAILS");
        flightDetails.addActionListener(this);
        details.add(flightDetails);

        customerDetails = new JMenuItem("ADD CUSTOMER DETAILS");
        customerDetails.addActionListener(this);
        details.add(customerDetails);

        bookFlight = new JMenuItem("BOOK FLIGHT");
        bookFlight.addActionListener(this);
        details.add(bookFlight);

        journeyDetail = new JMenuItem("JOURNEY DETAILS");
        journeyDetail.addActionListener(this);
        details.add(journeyDetail);

        ticketcancellation = new JMenuItem("CANCEL TICKET");
        ticketcancellation.addActionListener(this);
        details.add(ticketcancellation);



        JMenu ticket = new JMenu("TICKET");
        ticket.setForeground(Color.BLACK);
        mb.add(ticket); 

        JMenuItem boardingPass = new JMenuItem("BOARDING PASS");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);


        setBounds(0,0,1550,1000);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == flightDetails){
            new FlightInfo();

        }else if(ae.getSource() == customerDetails){
            new AddCustomer();

        }else if(ae.getSource() == journeyDetail){
            new JourneyDetails();

        }else if(ae.getSource() == bookFlight){
            new BookFlight();

        }else if(ae.getSource() == ticketcancellation){
            new CancelTicket();
        }
    }

    public static void main(String...vr){
        new Home();
    }
    
}
