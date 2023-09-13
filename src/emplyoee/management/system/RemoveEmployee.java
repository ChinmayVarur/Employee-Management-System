/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emplyoee.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author chinmayvarur
 */
public class RemoveEmployee extends JFrame implements ActionListener {
    
    Choice c;
    JButton delete, back;
    
    public RemoveEmployee(){
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel Lempid = new JLabel("Employee ID");
        Lempid.setFont(new Font("serif", Font.BOLD,20));
        Lempid.setBounds(50, 50, 150, 30);
        add(Lempid);
        
        c = new Choice();
        c.setBounds(200, 50, 170, 30);
        c.setBackground(Color.LIGHT_GRAY);
        c.add("Select an Option");
        add(c);
        
        try{
            Conn conn = new Conn();
            String query = "select * from employee";
            ResultSet rs = conn.stmt.executeQuery(query);
            
            while(rs.next())
                c.add(rs.getString("id"));
            
        }catch(Exception e){
            e.getMessage();
        }
        
        JLabel name1 = new JLabel("Name:");
        name1.setBounds(50, 150, 150, 30);
        name1.setFont(new Font("serif", Font.PLAIN, 20));
        add(name1);
        
        JLabel name2 = new JLabel();
        name2.setBounds(130, 150, 150, 30);
        name2.setFont(new Font("serif", Font.PLAIN, 20));
        add(name2);
        
        JLabel dob1 = new JLabel("DOB:");
        dob1.setBounds(50, 200, 150, 30);
        dob1.setFont(new Font("serif", Font.PLAIN, 20));
        add(dob1);
        
        JLabel dob2 = new JLabel();
        dob2.setBounds(130, 200, 150, 30);
        dob2.setFont(new Font("serif", Font.PLAIN, 20));
        add(dob2);
        
        JLabel addr1 = new JLabel("Address:");
        addr1.setBounds(50, 250, 150, 30);
        addr1.setFont(new Font("serif", Font.PLAIN, 20));
        add(addr1);
        
        JLabel addr2 = new JLabel();
        addr2.setBounds(130, 250, 150, 30);
        addr2.setFont(new Font("serif", Font.PLAIN, 20));
        add(addr2);
        
        JLabel phno1 = new JLabel("Phone:");
        phno1.setBounds(50, 300, 150, 30);
        phno1.setFont(new Font("serif", Font.PLAIN, 20));
        add(phno1);
        
        JLabel phno2 = new JLabel();
        phno2.setBounds(130, 300, 150, 30);
        phno2.setFont(new Font("serif", Font.PLAIN, 20));
        add(phno2);
        
        JLabel email1 = new JLabel("Email:");
        email1.setBounds(50, 350, 150, 30);
        email1.setFont(new Font("serif", Font.PLAIN, 20));
        add(email1);
        
        JLabel email2 = new JLabel();
        email2.setBounds(130, 350, 190, 30);
        email2.setFont(new Font("serif", Font.PLAIN, 20));
        add(email2);
        
        JLabel degree1 = new JLabel("Degree:");
        degree1.setBounds(50, 400, 150, 30);
        degree1.setFont(new Font("serif", Font.PLAIN, 20));
        add(degree1);
        
        JLabel degree2 = new JLabel();
        degree2.setBounds(130, 400, 150, 30);
        degree2.setFont(new Font("serif", Font.PLAIN, 20));
        add(degree2);
        
        JLabel emp1 = new JLabel("Employee ID:");
        emp1.setBounds(50, 450, 150, 30);
        emp1.setFont(new Font("serif", Font.PLAIN, 20));
        add(emp1);
        
        JLabel emp2 = new JLabel();
        emp2.setBounds(180, 450, 150, 30);
        emp2.setFont(new Font("serif", Font.PLAIN, 20));
        add(emp2);
        
        try{
            Conn conn = new Conn();
            String query = "select * from employee where id ='"+c.getSelectedItem()+"'";
            ResultSet rs = conn.stmt.executeQuery(query);
            
            while(rs.next()){
                name2.setText(rs.getString("name"));
                dob2.setText(rs.getString("dob"));
                addr2.setText(rs.getString("addr"));
                phno2.setText(rs.getString("phone"));
                email2.setText(rs.getString("email"));
                degree2.setText(rs.getString("degree"));
                emp2.setText(rs.getString("id"));
            }
        }catch(Exception e){
            e.getMessage();
        }
        c.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn conn = new Conn();
                    String query = "select * from employee where id ='"+c.getSelectedItem()+"'";
                    ResultSet rs = conn.stmt.executeQuery(query);

                    while(rs.next()){
                        name2.setText(rs.getString("name"));
                        dob2.setText(rs.getString("dob"));
                        addr2.setText(rs.getString("addr"));
                        phno2.setText(rs.getString("phone"));
                        email2.setText(rs.getString("email"));
                        degree2.setText(rs.getString("degree"));
                        emp2.setText(rs.getString("id"));
                    }
                }catch(Exception e){
                    e.getMessage();
                }
            }
        });

        delete = new JButton("Remove");
        delete.setBounds(250, 550, 100, 40);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(400, 550, 100, 40);
        back .addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/remove.png"));
        Image i2 = i1.getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(280,0, 700, 400);
        add(image);
 
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Home();
        }
        else{
            try{
                Conn conn = new Conn();
                String query = "delete from employee where id = '"+c.getSelectedItem()+"'";
                conn.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Information deleted successfully");
                setVisible(false);
                new Home();
                
            }catch(Exception e){
                e.getMessage();
            }
        }
    }
    public static void main(String[] args) {
        
        new RemoveEmployee();
    }
}
