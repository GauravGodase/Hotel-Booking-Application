package hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class AddCustomers extends JFrame implements ActionListener {

    JComboBox comboid;
    JTextField tfnumber, tfname, tfcountry, tfdeposite;
    JRadioButton rmale, rfemale;
    Choice croom;
    JLabel checkintime;
    JButton back, add;

    AddCustomers() {

        JLabel text = new JLabel("New Customer Form");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Railway", Font.PLAIN, 20));
        add(text);

        JLabel lblid = new JLabel("ID ");
        lblid.setBounds(35, 80, 100, 20);
        lblid.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblid);

        String idoption[] = {"Aadhar card", "Passport", "Driving License", "Voter-Id-card", "Ration card"};
        comboid = new JComboBox(idoption);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber = new JLabel("Number ");
        lblnumber.setBounds(35, 120, 150, 25);
        lblnumber.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200, 120, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name ");
        lblname.setBounds(35, 160, 150, 25);
        lblname.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);

        JLabel lblgender = new JLabel("Gender ");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200, 200, 60, 25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270, 200, 100, 25);
        add(rfemale);

        JLabel lblcountry = new JLabel("Country ");
        lblcountry.setBounds(35, 240, 100, 20);
        lblcountry.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        add(tfcountry);

        JLabel lblroom = new JLabel("Room Number ");
        lblroom.setBounds(35, 280, 150, 20);
        lblroom.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lblroom);

        croom = new Choice();

        try {
            Conn conn = new Conn();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        croom.setBounds(200, 280, 150, 25);
        add(croom);

        JLabel lbltime = new JLabel("Checkin Time ");
        lbltime.setBounds(35, 320, 150, 20);
        lbltime.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lbltime);

        Date date = new Date();

        checkintime = new JLabel("" + date);
        checkintime.setBounds(200, 320, 140, 25);
        checkintime.setFont(new Font("Railway", Font.PLAIN, 14));
        add(checkintime);

        JLabel lbldeposite = new JLabel("Deposite ");
        lbldeposite.setBounds(35, 360, 100, 20);
        lbldeposite.setFont(new Font("Railway", Font.PLAIN, 20));
        add(lbldeposite);

        tfdeposite = new JTextField();
        tfdeposite.setBounds(200, 360, 150, 25);
        add(tfdeposite);

        add = new JButton("ADD");
        add.setBounds(50, 410, 120, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(200, 410, 150, 30);
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);     //location x,location y,length,breath
        add(image);

        setBounds(550, 250, 800, 570);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if (rmale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposite = tfdeposite.getText();

            try {
                String query = "insert into customer values('" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + room + "', '" + time + "', '" + deposite + "')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '" + room + "'";

                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "New Customer Added Successfully!!!");
                setVisible(false);

                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);

            new Reception();

        }
    }

    public static void main(String[] args) {
        new AddCustomers();
    }
}
