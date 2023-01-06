
package hotel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Customerinfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
     Customerinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
       
        
        
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10, 10, 100, 20);
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l1);
        
          JLabel l2 = new JLabel("Number ");
        l2.setBounds(160, 10, 100, 20);
        l2.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l2);
        
        
        JLabel l3 = new JLabel(" Name");
        l3.setBounds(290, 10, 100, 20);
        l3.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l3);
        
        JLabel l4 = new JLabel(" Gender");
        l4.setBounds(410, 10, 100, 20);
        l4.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l4);
        
        JLabel l5 = new JLabel(" Country ");
        l5.setBounds(510, 10, 100, 20);
        l5.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l5);
        
        
         JLabel l6 = new JLabel(" Room Number");
        l6.setBounds(640, 10, 100, 20);
        l6.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l6);
        
        JLabel l7 = new JLabel(" Checkin time");
        l7.setBounds(760, 10, 100, 20);
        l7.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l7);
        
        JLabel l8 = new JLabel(" Deposite ");
        l8.setBounds(900, 10, 100, 20);
        l8.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l8);
        
        table = new JTable();
        table.setBounds(25,40,1000,400);
        add(table);

        
        try{
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel (rs));
        }catch(Exception e){
           e.printStackTrace();
        }
        
       back = new JButton("Back");
        back.setBounds(450, 500, 200, 50);
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        
        
        setBounds(430, 250, 1100, 650);
        setVisible(true);

         
         
    }
     
      public void actionPerformed(ActionEvent ae) {
      
      setVisible(false);
      new Reception();
      
      }
      public static void main(String[] args) {
        new Customerinfo();
    }
}
