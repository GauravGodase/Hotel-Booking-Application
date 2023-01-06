package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hotel extends JFrame implements ActionListener {

    Hotel() {
        //setSize(1366,565);
        //setLocation(100,100);
        setBounds(100, 100, 1366, 565);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel Image = new JLabel(i1);
        Image.setBounds(0, 0, 1366, 565);     //location x,location y,length,breath
        add(Image);
        JLabel text = new JLabel("TOURS AND TRAVELS SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.GREEN);
        text.setFont(new Font("serif", Font.PLAIN, 25));  //font family,font type,font size
        Image.add(text);

        JButton next = new JButton("NEXT");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.ORANGE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 18));

        Image.add(next);

        setVisible(true);

        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new RegistrationCustomer();

    }

    public static void main(String[] args) {
        new Hotel();
    }

}
