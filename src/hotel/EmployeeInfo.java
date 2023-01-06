
package hotel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
     EmployeeInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
       
        
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 10, 100, 20);
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l1);
        
          JLabel l2 = new JLabel("Age ");
        l2.setBounds(170, 10, 100, 20);
        l2.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l2);
        
        
        JLabel l3 = new JLabel(" Gender");
        l3.setBounds(290, 10, 100, 20);
        l3.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l3);
        
        JLabel l4 = new JLabel(" Job");
        l4.setBounds(400, 10, 100, 20);
        l4.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l4);
        
        JLabel l5 = new JLabel(" Salary ");
        l5.setBounds(540, 10, 100, 20);
        l5.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l5);
        
        
         JLabel l6 = new JLabel(" Phone");
        l6.setBounds(670, 10, 100, 20);
        l6.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l6);
        
        JLabel l7 = new JLabel(" Email");
        l7.setBounds(790, 10, 100, 20);
        l7.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l7);
        
        JLabel l8 = new JLabel(" Aadhar ");
        l8.setBounds(910, 10, 100, 20);
        l8.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l8);
        
        table = new JTable();
        table.setBounds(25,40,1000,400);
        add(table);

        
        try{
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel (rs));
        }catch(Exception e){
           e.printStackTrace();
        }
        
       back = new JButton("Back");
        back.setBounds(430, 450, 200, 50);
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        
        
        setBounds(410, 250, 1100, 600);
        setVisible(true);

         
         
    }
     
      public void actionPerformed(ActionEvent ae) {
      
      setVisible(false);
      new Reception();
      
      }
      public static void main(String[] args) {
        new EmployeeInfo();
    }
}
