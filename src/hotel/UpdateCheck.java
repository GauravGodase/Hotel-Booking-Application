package hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom, tfname, tfcheckin, tfpaid, tfpending;
    JButton check, update, back;

    UpdateCheck() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setBounds(90, 20, 200, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 20);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblid);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 120, 150, 20);
        lblroom.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        tfroom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfroom);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 100, 20);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfname);

        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 200, 100, 20);
        lblcheckin.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblcheckin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 200, 150, 25);
        tfcheckin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfcheckin);

        JLabel lblpaid = new JLabel("Amount Paid");
        lblpaid.setBounds(30, 240, 100, 20);
        lblpaid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblpaid);

        tfpaid = new JTextField();
        tfpaid.setBounds(200, 240, 150, 25);
        tfpaid.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfpaid);

        JLabel lblpending = new JLabel(" Pending Amount");
        lblpending.setBounds(25, 280, 150, 20);
        lblpending.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblpending);

        tfpending = new JTextField();
        tfpending.setBounds(200, 280, 150, 25);
        tfpending.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfpending);

        check = new JButton("Check");
        check.setBounds(60, 370, 150, 30);
        check.setBackground(Color.ORANGE);
        check.setForeground(Color.BLACK);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(240, 370, 150, 30);
        update.setBackground(Color.ORANGE);
        update.setForeground(Color.BLACK);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(420, 370, 150, 30);
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);     //location x,location y,length,breath
        add(image);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
       try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }  
        add(ccustomer);

       

        setBounds(500, 250, 1000, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where  number = '" + id + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposite"));

                }

                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText("" + amountPaid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {

            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposite = tfpaid.getText();

            try {

                Conn c = new Conn();
                c.s.executeUpdate("update customer set room = '"+ room+"', name ='"+name+"', checkintime ='"+checkin+"', deposite ='" +deposite+"' where number = '"+number+"'");
                JOptionPane.showMessageDialog(null, "Data Updated successfully!!!");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else  {
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
