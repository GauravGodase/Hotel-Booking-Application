package hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddDrivers extends JFrame implements ActionListener {

    JButton add, cancel;
    JTextField tfname, tfcompany, tfage, tfbrand, tflocation;
    JComboBox typecombo, gendercombo, availabelcombo;

    AddDrivers() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Drivers");
        heading.setBounds(150, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 70, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);

        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60, 110, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        add(tfage);

        JLabel lblclean = new JLabel("Gender ");
        lblclean.setBounds(60, 150, 120, 30);
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblclean);

        String ageoption[] = {"Male", "Female"};
        gendercombo = new JComboBox(ageoption);
        gendercombo.setBounds(200, 150, 150, 30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        JLabel lblprice = new JLabel("Car Comapany");
        lblprice.setBounds(60, 190, 120, 30);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblprice);

        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);

        JLabel lbltype = new JLabel("Car Model");
        lbltype.setBounds(60, 230, 120, 30);
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltype);

        tfbrand = new JTextField();
        tfbrand.setBounds(200, 230, 150, 30);
        add(tfbrand);

        JLabel lblavailable = new JLabel("Available");
        lblavailable.setBounds(60, 270, 120, 30);
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblavailable);

        String driveroption[] = {"Available", "Busy"};
        availabelcombo = new JComboBox(driveroption);
        availabelcombo.setBounds(200, 270, 150, 30);
        availabelcombo.setBackground(Color.WHITE);
        add(availabelcombo);

        JLabel lbllocation = new JLabel("Location");
        lbllocation.setBounds(60, 310, 120, 30);
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);

        add = new JButton("Add Driver");
        add.setBounds(60, 370, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 370, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 60, 550, 350);     //location x,location y,length,breath
        add(image);

        setBounds(510, 280, 950, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfbrand.getText();
            String available = (String) availabelcombo.getSelectedItem();;
            String location = tflocation.getText();;

             if (name.equals("")) {
            JOptionPane.showMessageDialog(null, " Name should not be empty!");
            return;
        }

        /* if (email.equals("") &&  contains("@") && contains (".com")){
         JOptionPane.showMessageDialog(null, "Invalid email! ");
         return;
         }*/
        
        
        if (age.equals("")) {
            JOptionPane.showMessageDialog(null, " Age should not be empty!");
            return;
        }
        if (company.equals("")) {
            JOptionPane.showMessageDialog(null, " Company should not be empty!");
            return;
        }

        if (brand.equals("")) {
            JOptionPane.showMessageDialog(null, " Brand should not be empty!");
            return;
        }

        if (location.equals("")) {
            JOptionPane.showMessageDialog(null, " Location should not be empty!");
            return;
        }
        
            try {
                Conn conn = new Conn();
                String str = "insert into driver values ('" + name + "','" + age + "','" + gender + "','" + company + "','" + brand + "','" + available + "','" + location + "')";
                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "New Driver Added successsfully!!");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddDrivers();
    }
}
