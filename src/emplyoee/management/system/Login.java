/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emplyoee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author chinmayvarur
 */
public class Login extends JFrame implements ActionListener {
    
    JTextField usrT;
    JPasswordField pwT;
    
    public Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel usrL = new JLabel("Username :");
        usrL.setBounds(40, 20, 100, 30);
        add(usrL);
        
        JLabel pwL = new JLabel("Password :");
        pwL.setBounds(40, 70, 100, 30);
        add(pwL);
        
        usrT = new JTextField();
        usrT.setBounds(120, 20, 100, 30);
        add(usrT);
        
        pwT = new JPasswordField();
        pwT.setBounds(120, 70, 100, 30);
        add(pwT);
        
        JButton login = new JButton("LOGIN");
        login.setBounds(120, 120, 100, 30);
        login.setForeground(Color.BLUE);
        login.setBackground(Color.ORANGE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,  0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String username = usrT.getText();
            String password = pwT.getText();
            
            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            ResultSet rs = c.stmt.executeQuery(query);
            
            if(rs.next()){
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid Username or password");
                usrT.setText("");
                pwT.setText("");
            }
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
