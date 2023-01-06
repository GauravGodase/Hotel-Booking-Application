package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class UserDashboard extends JFrame implements ActionListener {

    JButton form,room,back;
    
    public UserDashboard() {
        //super("HOTEL MANAGEMENT SYSTEM");

        setForeground(Color.CYAN);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/BG0.jpg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 500, Image.SCALE_DEFAULT  );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1950, 500);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setForeground(Color.GREEN);
        text.setFont(new Font("Tahoma", Font.ITALIC, 30));
        text.setBounds(600, 60, 1000, 85);
        image.add(text);

       
        
      
        
        
        
        
        
        
        
        

        setSize(1950, 1090);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {
        

    }

    public static void main(String[] args) {
        new UserDashboard(). setVisible(true);
    }

}
