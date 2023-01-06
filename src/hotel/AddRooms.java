package hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener {

    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox typecombo, availablecombo, cleancombo;

    AddRooms() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Rooms");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);

        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setBounds(60, 80, 120, 30);
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblroomno);

        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);

        JLabel lblavailable = new JLabel("Available");
        lblavailable.setBounds(60, 130, 120, 30);
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblavailable);

        String availableoption[] = {"Available", "Occupied"};
        availablecombo = new JComboBox(availableoption);
        availablecombo.setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setBounds(60, 180, 120, 30);
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblclean);

        String cleanoption[] = {"Cleaned", "Not Cleaned"};
        cleancombo = new JComboBox(cleanoption);
        cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(60, 230, 120, 30);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);

        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setBounds(60, 280, 120, 30);
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltype);

        String typeoption[] = {"Single bed", "Doubled Bed"};
        typecombo = new JComboBox(typeoption);
        typecombo.setBounds(200, 280, 150, 30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);

        add = new JButton("Add Rooms");
        add.setBounds(40, 400, 150, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 400, 150, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(400, 60, 550, 400);     //location x,location y,length,breath
        add(image);

        setBounds(470, 250, 1000, 570);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {
            String roomnumber = tfroom.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typecombo.getSelectedItem();

           
            
            
            try {
                Conn conn = new Conn();
                String str = "insert into room values ('" + roomnumber + "','" + availability + "','" + status + "','" + price + "','" + type + "')";
                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "New Room Added successsfully!!");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddRooms();
    }
}
