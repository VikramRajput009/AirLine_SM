import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;

import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{

    JTable table;
    JTextField pnr;
    JButton show;

    public JourneyDetails(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        //
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setForeground(Color.BLACK);
        lblpnr.setBounds(50,50,100,25);
        lblpnr.setFont(new Font("Tahoma",Font.PLAIN, 16));
        add(lblpnr);

        //
        pnr = new JTextField();
        pnr.setBounds(160,50,120,25);
        add(pnr);



        //
        show = new JButton("Show Details");
        show.setBounds(290,50,120,25);
        show.setForeground(Color.WHITE);
        show.setBackground(Color.BLACK);
        show.addActionListener(this);
        add(show);


        //
        table = new JTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,800,500);
        jsp.setBackground(Color.WHITE);
        add(jsp);

        setBounds(400,150,800,500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        try{
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from reservation where PNR = '"+ pnr.getText() +"'");

            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }

            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String...vr){

        new JourneyDetails();

    }
    
}
