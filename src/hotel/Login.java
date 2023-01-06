package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login, cancel,save;
    

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu loginsystem = new JMenu(" Login Account");
         
        loginsystem.setForeground(Color.BLUE);
        menuBar.add(loginsystem);

        JMenuItem admin = new JMenuItem("ADMIN LOGIN");
         admin.addActionListener(this);
        loginsystem.add(admin);
        
        

        JLabel user = new JLabel("USERNAME");
        user.setBounds(40, 70, 100, 30);
        add(user);

        username = new JTextField();
        username.setBounds(150, 70, 150, 30);
        add(username);

        JLabel pass = new JLabel("PASSWORD");
        pass.setBounds(40, 120, 100, 30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150, 120, 150, 30);
        add(password);

        
        
        
        login = new JButton("LOGIN");
        login.setBounds(40, 200, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("CANCEL");
        cancel.setBounds(180, 200, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 35, 200, 250);     //location x,location y,length,breath
        add(image);

        setBounds(600, 300, 600, 400);
        setVisible(true);

    }
    
    
 

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {

            String user = username.getText();
            String pass = password.getText();

            try {

                Conn c = new Conn();
                String query = "select * from register where user = '" + user + "'and pass = '" + pass + "'";

                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();

                } else {
                    JOptionPane.showMessageDialog(null, " invalid username or password");
                    setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (ae.getSource() == cancel) {
            setVisible(false);

        } if (ae.getActionCommand().equals("ADMIN LOGIN")) {
            new LoginAdmin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
