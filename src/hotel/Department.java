package hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Department() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Department");
        l1.setBounds(180, 10, 100, 20);
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l1);

        JLabel l2 = new JLabel("Budget ");
        l2.setBounds(420, 10, 100, 20);
        l2.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(l2);

        table = new JTable();
        table.setBounds(40, 50, 700, 350);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(280, 400, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(500, 250, 900, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        setVisible(false);
        new Reception();

    }

    public static void main(String[] args) {
        new Department();
    }
}
