/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emplyoee.management.system;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author chinmayvarur
 */
public class UpdateEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JLabel LBname,LBdob, LBempid;
    JTextField tfphno, tfaddr, tfemail, tfdegree;
    JLabel ID;
    JButton add, back;
    String empId;
    
    public UpdateEmployee(String empId){
        this.empId = empId;
        getContentPane().setBackground(Color.getHSBColor(0.6f, 0.6f, 0.9f));
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,100, 500, 500);
        add(image);
        

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(280, 30, 500,50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        add(heading);
        
        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("serif", Font.PLAIN, 20));
        add(name);
        
        LBname = new JLabel();
        LBname.setBounds(130, 150, 150, 30);
        add(LBname);
        
        JLabel dob = new JLabel("D.O.B:");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("serif", Font.PLAIN, 20));
        add(dob);
        
        LBdob = new JLabel();
        LBdob.setBounds(130, 200, 150, 30);
        add(LBdob);

        JLabel addr = new JLabel("Address:");
        addr.setBounds(50, 250, 150, 30);
        addr.setFont(new Font("serif", Font.PLAIN, 20));
        add(addr);
        
        tfaddr = new JTextField();
        tfaddr.setBounds(130, 250, 200, 30);
        add(tfaddr);
        
        JLabel phno = new JLabel("Phone:");
        phno.setBounds(50, 300, 150, 30);
        phno.setFont(new Font("serif", Font.PLAIN, 20));
        add(phno);
        
        tfphno = new JTextField();
        tfphno.setBounds(130, 300, 200, 30);
        add(tfphno);
        
        JLabel email = new JLabel("Email:");
        email.setBounds(50, 350, 150, 30);
        email.setFont(new Font("serif", Font.PLAIN, 20));
        add(email);
        
        tfemail = new JTextField();
        tfemail.setBounds(130, 350, 200, 30);
        add(tfemail);
        
        JLabel degree = new JLabel("Degree:");
        degree.setBounds(50, 400, 150, 30);
        degree.setFont(new Font("serif", Font.PLAIN, 20));
        add(degree);
        
        tfdegree = new JTextField();
        tfdegree.setBounds(130, 400, 200, 30);
        add(tfdegree);

        
        JLabel empID = new JLabel("Employee ID:");
        empID.setBounds(50, 450, 150, 30);
        empID.setFont(new Font("serif", Font.PLAIN, 20));
        add(empID);
        
        LBempid = new JLabel();
        LBempid.setBounds(200, 450, 150, 30);
        add(LBempid);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where ID = '"+empId+"'";
            ResultSet rs = c.stmt.executeQuery(query);
            
            while(rs.next()){
                LBname.setText(rs.getString("name"));
                LBdob.setText(rs.getString("dob"));
                LBempid.setText(rs.getString("id"));                
            }
        }catch(Exception e){
            e.getMessage();
        }
        add = new JButton("Update Details");
        add.setBounds(250, 550, 160, 50);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550 , 160, 50);
        back.addActionListener(this);
        add(back);
  
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){


            String Address = tfaddr.getText();
            String Phone = tfphno.getText();
            String Email = tfemail.getText();
            String Degree = tfdegree.getText();
            
            try{
                Conn conn = new Conn();
                String query = "update employee set addr ='"+Address+"', phone ='"+Phone+"',email ='"+Email+"',degree ='"+Degree+"' where id ='"+empId+"'";
                conn.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated successfully");
                setVisible(false);
                new Home();

                }catch(Exception e){
                    e.printStackTrace();
                }
            
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        new UpdateEmployee("");
    }
}
