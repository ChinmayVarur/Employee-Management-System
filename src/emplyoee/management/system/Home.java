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
public class Home extends JFrame implements ActionListener {
    
    JButton add, view, update, remove;
    
    public Home(){
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0, 0, 1120, 630);
       add(image);
       
       JLabel heading = new JLabel("Home Page");
       heading.setBounds(405, 230, 400, 60);
       heading.setFont(new Font("Times New Roman",Font.BOLD, 55));
       image.add(heading);
       
       add = new JButton("Add Employee");
       add.setBounds(370, 300, 160, 50);
       add.addActionListener(this);
       image.add(add);
       
       view = new JButton("View Employees");
       view.setBounds(540, 300, 160, 50);
       view.addActionListener(this);
       image.add(view);
       
       update = new JButton("Update Employee");
       update.setBounds(370, 360, 160, 50);
       update.addActionListener(this);
       image.add(update);
       
       remove = new JButton("Remove Employee");
       remove.setBounds(540, 360, 160, 50);
       remove.addActionListener(this);
       image.add(remove);
       
       setSize(1120, 630);
       setLocation(180, 100);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == add){
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource() == view){
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new ViewEmployee();

        }
        else{
            setVisible(false);
            new RemoveEmployee();
        }
            
    }
    
    public static void main(String args[]){
        new Home();
    }
}