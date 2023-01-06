package hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom, tfavailable, tfstatus, tfpaid, tfpending;
    JButton check, update, back;

    UpdateRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Room Status");
        text.setBounds(30, 20, 300, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 20);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblid);

        tfroom = new JTextField();
        tfroom.setBounds(200, 130, 150, 25);
        tfroom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfroom);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 150, 20);
        lblroom.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblroom);

        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setBounds(30, 180, 100, 20);
        lblavailable.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblavailable);

        tfavailable = new JTextField();
        tfavailable.setBounds(200, 180, 150, 25);
        tfavailable.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfavailable);

        JLabel lblcheckin = new JLabel("Cleaning Status");
        lblcheckin.setBounds(30, 230, 130, 20);
        lblcheckin.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblcheckin);

        tfstatus = new JTextField();
        tfstatus.setBounds(200, 230, 150, 25);
        tfstatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tfstatus);

        check = new JButton("Check");
        check.setBounds(30, 300, 100, 30);
        check.setBackground(Color.ORANGE);
        check.setForeground(Color.BLACK);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(150, 300, 100, 30);
        update.setBackground(Color.ORANGE);
        update.setForeground(Color.BLACK);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(270, 300, 100, 30);
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(400, 60, 500, 300);     //location x,location y,length,breath
        add(image);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 40);
        add(ccustomer);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setBounds(550, 250, 1000, 500);
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

                }

                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("claeaning_status"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {

            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();

            try {

                Conn c = new Conn();
                c.s.executeUpdate("update room set availability = '" + available + "', claeaning_status ='" + status + "' where roomnumber = '" + room + "'");
                JOptionPane.showMessageDialog(null, "Data Updated successfully!!!");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
