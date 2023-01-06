
package hotel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    
     SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel text = new JLabel("Search For Room");
         text.setBounds(400, 30, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(text);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50, 100, 100, 20);
        lblbed.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(lblbed);
        
        bedType = new JComboBox( new String[]{"Single bed","Doubled bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        available = new JCheckBox("Only Displaly available");
         available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50, 160, 100, 20);
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l1);
        
          JLabel l2 = new JLabel("Availability ");
        l2.setBounds(270, 160, 100, 20);
        l2.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l2);
        
        
        JLabel l3 = new JLabel(" Status");
        l3.setBounds(450, 160, 100, 20);
        l3.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l3);
        
        JLabel l4 = new JLabel(" Price");
        l4.setBounds(670, 160, 100, 20);
        l4.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l4);
        
        JLabel l5 = new JLabel(" Bed Type");
        l5.setBounds(870, 160, 100, 20);
        l5.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l5);
        
        
        table = new JTable();
        table.setBounds(15,200,1000,300);
        add(table);

        
        try{
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel (rs));
        }catch(Exception e){
           e.printStackTrace();
        }
        
       back = new JButton("Back");
        back.setBounds(500, 520, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
         submit = new JButton("Submit");
        submit.setBounds(300, 520, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        
        
        setBounds(450, 250, 1050, 650);
        setVisible(true);

         
         
    }
     
      public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==submit){
          
          try{
              String query1 = "select * from room where bed_type ='"+bedType.getSelectedItem()+"'";
               String query2 = "select * from room where availability = 'Available' AND bed_type='"+bedType.getSelectedItem()+"'" ;     
              
               
               Conn conn = new Conn();
               ResultSet rs;
               if(available.isSelected()){
                   rs = conn.s.executeQuery(query2);
               }else{
                   rs = conn.s.executeQuery(query1);
               }
              
               table.setModel(DbUtils.resultSetToTableModel (rs));

               
          }catch(Exception e){
              e.printStackTrace();
          }
          
      }else{
      setVisible(false);
      new Reception();
      }
      }
      public static void main(String[] args) {
        new SearchRoom();
    }
}
