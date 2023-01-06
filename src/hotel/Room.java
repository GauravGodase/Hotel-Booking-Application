package hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Room() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(650, 100, 500, 400);     //location x,location y,length,breath
        add(image);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(30, 10, 100, 20);
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l1);

        JLabel l2 = new JLabel("Availability ");
        l2.setBounds(150, 10, 100, 20);
        l2.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l2);

        JLabel l3 = new JLabel(" Status");
        l3.setBounds(270, 10, 100, 20);
        l3.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l3);

        JLabel l4 = new JLabel(" Price");
        l4.setBounds(390, 10, 100, 20);
        l4.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l4);

        JLabel l5 = new JLabel(" Bed Type");
        l5.setBounds(520, 10, 100, 20);
        l5.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l5);

        table = new JTable();
        table.setBounds(20, 40, 600, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(300,700,120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(400, 200, 1200, 800);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        setVisible(false);
        new Reception();

    }

    public static void main(String[] args) {
        new Room();
    }
}
