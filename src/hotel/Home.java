package hotel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;


public class Home extends JFrame {
    JButton save;
    
    
    Home(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(600, 300, 600, 400);
        setVisible(true);

        

        ImageIcon saveImage = new ImageIcon("icons/SaveButton.png");
        setLayout(new FlowLayout());
         setBounds(40,250,120,30);
        save = new JButton(saveImage);
        add(save);
}
public static void main (String[]args){
    
}
}