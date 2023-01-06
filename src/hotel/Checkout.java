package hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {

    JTable table;
    JButton back, checkout;
    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime;

    Checkout() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("CheckOut");
        text.setBounds(100, 20, 100, 30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 12));
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);

        /* ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
         Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i1);
         image.setBounds(310, 80, 20, 20);     //location x,location y,length,breath
         add(image);
        
         */
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);

        lblroomnumber = new JLabel("");
        lblroomnumber.setBounds(150, 130, 100, 30);
        add(lblroomnumber);

        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 180, 100, 30);
        add(lblcheckin);

        lblcheckintime = new JLabel("");
        lblcheckintime.setBounds(150, 180, 100, 30);
        add(lblcheckintime);

        JLabel lblcheckout = new JLabel("Checkin Time");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);

        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150, 230, 150, 30);
        add(lblcheckouttime);

        checkout = new JButton("Checkout");
        checkout.setBounds(30, 280, 120, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBounds(170, 280, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350, 50, 400, 250);     //location x,location y,length,breath
        add(image);

        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 150, 25);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        add(ccustomer);

        setBounds(550, 250, 800, 570);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == checkout) {

            String query1 = "delete from customer where number = '" + ccustomer.getSelectedItem() + "'";
            String query2 = "update room set availability = 'Available' where roomnumber ='" + lblroomnumber.getText() + "'";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Checkout done!!!");

                setVisible(false);
                new Reception();

            } catch (Exception e) {

            }

        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Checkout();
    }
}
