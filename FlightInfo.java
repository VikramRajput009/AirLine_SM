import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;

import javax.swing.*;
import javax.swing.event.*;

public class FlightInfo extends JFrame{

    public FlightInfo(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        //
        JLabel heading = new JLabel("FLIGHT INFORMATION");
        heading.setForeground(Color.BLACK);
        heading.setBounds(300,0,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN, 20));
        add(heading);


        JTable table = new JTable();
        try{
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        table.setBounds(0,60,800,500);
        add(table);

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,60,800,500);
        add(jsp);

        setBounds(400,200,800,500);
        setVisible(true);

    }
    public static void main(String...vr){
        new FlightInfo();

    }
    
}
