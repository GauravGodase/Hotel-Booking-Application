package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegistrationCustomer extends JFrame implements ActionListener {

    JTextField username, tfname, tfno, tfcount, tfaddress;
    JPasswordField password;
    JButton register, cancel,account;
    JComboBox gendercombo;

    RegistrationCustomer() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel name = new JLabel("NAME");
        name.setBounds(70, 60, 100, 50);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(260, 70, 150, 30);
        add(tfname);

        JLabel phonenumber = new JLabel("MOBILE NUMBER");
        phonenumber.setBounds(70, 120, 100, 50);
        add(phonenumber);

        tfno = new JTextField();
        tfno.setBounds(260, 130, 150, 30);
        add(tfno);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(70, 180, 100, 50);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        String ageoption[] = {"Male", "Female", "Other"};
        gendercombo = new JComboBox(ageoption);
        gendercombo.setBounds(260, 190, 150, 30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        JLabel count = new JLabel("NUMBER OF MEMBERS");
        count.setBounds(70, 240, 200, 50);
        add(count);

        tfcount = new JTextField();
        tfcount.setBounds(260, 250, 150, 30);
        add(tfcount);

        JLabel address = new JLabel("ADDRESS");
        address.setBounds(70, 300, 100, 50);
        add(address);

        tfaddress = new JTextField();
        tfaddress.setBounds(260, 295, 150, 50);
        add(tfaddress);

        JLabel user = new JLabel("CREATE USERNAME");
        user.setBounds(70, 360, 150, 50);
        add(user);

        username = new JTextField();
        username.setBounds(260, 370, 150, 30);
        add(username);

        JLabel pass = new JLabel("CREATE PASSWORD");
        pass.setBounds(70, 420, 150, 50);
        add(pass);

        password = new JPasswordField();
        password.setBounds(260, 430, 150, 30);
        add(password);

        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/AddUser2.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,20,450,500);
        add(image);
        
        
        register = new JButton("Register");
        register.setBounds(130, 500, 200, 50);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);

        cancel = new JButton("CANCEL");
        cancel.setBounds(390, 500, 200, 50);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        
         account = new JButton("Already have Account");
        account.setBounds(620, 520, 200, 25);
        account.setBackground(Color.WHITE);
        account.setForeground(Color.BLUE);
        account.addActionListener(this);
        add(account);
       
   
        
        
        setBounds(200, 100, 900, 700);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == register) {

            String name = tfname.getText();
            String number = tfno.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String members = tfcount.getText();
            String address = tfaddress.getText();

            String user = username.getText();
            String pass = password.getText();

            try {
                Conn conn = new Conn();
                String str = "insert into register values ('" + name + "','" + number + "','" + gender + "','" + members + "','" + address + "','" + user + "','" + pass + "')";
                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "Register successsfully!!");

                setVisible(false);
                new Login();
                
                
            } catch (Exception e) {
                e.printStackTrace();

            }
        } else if (ae.getSource()== account){
            
            setVisible(false);
            new Login();
        }

    }

    public static void main(String[] args) {
        new RegistrationCustomer();
    }
}
