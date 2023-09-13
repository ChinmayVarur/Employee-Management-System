/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emplyoee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author chinmayvarur
 */
public class Splash extends JFrame implements ActionListener {
    
    public Splash(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(50, 40, 1200, 60);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("serif",Font.BOLD,59));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1650, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        JButton clickhere = new JButton("Click here to continue");
        clickhere.setBounds(440, 440, 180, 50);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.RED );
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        setSize(1170, 650); 
        setLocation(150, 100);
        setVisible(true);
        
        while(true){
            heading.setVisible(true);
            try{
                Thread.sleep(900);
            }catch(Exception e){}
            
            heading.setVisible(false);
            try{
                Thread.sleep(900);
            }catch(Exception e){}
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new Splash();
    }
    
}
