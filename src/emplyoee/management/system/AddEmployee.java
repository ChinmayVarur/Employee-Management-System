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
/**
 *
 * @author chinmayvarur
 */
public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField TFname,Taddr,Tphno,Temail;
    JLabel ID;
    JButton add, back;
    JComboBox Cbdegree;
    JDateChooser cal;
    
    public AddEmployee(){
        getContentPane().setBackground(Color.getHSBColor(0.5f, 0.5f, 0.8f));
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/add.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300,100, 600, 400);
        add(image);
        

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(280, 30, 500,50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        add(heading);
        
        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("serif", Font.PLAIN, 20));
        add(name);
        
        TFname = new JTextField();
        TFname.setBounds(130, 150, 200, 30);
        add(TFname);
        
        JLabel dob = new JLabel("D.O.B:");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("serif", Font.PLAIN, 20));
        add(dob);
        
        cal = new JDateChooser();
        cal.setBounds(130, 200, 200, 30);
        add(cal);
        
        JLabel addr = new JLabel("Address:");
        addr.setBounds(50, 250, 150, 30);
        addr.setFont(new Font("serif", Font.PLAIN, 20));
        add(addr);
        
        Taddr = new JTextField();
        Taddr.setBounds(130, 250, 200, 30);
        add(Taddr);
        
        JLabel phno = new JLabel("Phone:");
        phno.setBounds(50, 300, 150, 30);
        phno.setFont(new Font("serif", Font.PLAIN, 20));
        add(phno);
        
        Tphno = new JTextField();
        Tphno.setBounds(130, 300, 200, 30);
        add(Tphno);
        
        JLabel email = new JLabel("Email:");
        email.setBounds(50, 350, 150, 30);
        email.setFont(new Font("serif", Font.PLAIN, 20));
        add(email);
        
        Temail = new JTextField();
        Temail.setBounds(130, 350, 200, 30);
        add(Temail);
        
        JLabel degree = new JLabel("Degree:");
        degree.setBounds(50, 400, 150, 30);
        degree.setFont(new Font("serif", Font.PLAIN, 20));
        add(degree);
        
        String degree_list[] ={"Select an option","12th","BA","BBA","BCA","BCom","BTech","BSC","Diploma","MA","MBA","MCA","MCom","MTech","MSC"}; 
        Cbdegree = new JComboBox(degree_list);
        Cbdegree.setBounds(130, 400, 200, 30);
        Cbdegree.setBackground(Color.WHITE);
        add(Cbdegree);
        
        JLabel empID = new JLabel("Employee ID:");
        empID.setBounds(50, 450, 150, 30);
        empID.setFont(new Font("serif", Font.PLAIN, 20));
        add(empID);
        
        ID = new JLabel(""+number);
        ID.setBounds(175, 450, 150, 30);
        ID.setFont(new Font("serif", Font.PLAIN, 20));
        add(ID);
        
       add = new JButton("Add Details");
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
            String Name = TFname.getText();
            String DOB = ((JTextField) cal.getDateEditor().getUiComponent()).getText();
            String Address = Taddr.getText();
            String Phone = Tphno.getText();
            String Email = Temail.getText();
            String Degree = (String) Cbdegree.getSelectedItem();
            String EMPID = ID.getText();
            
            if(Phone.length() != 10){
                JOptionPane.showMessageDialog(null, "Please enter a valid phone number");
                setVisible(false);
                new AddEmployee();
            }
            
            else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into employee values('"+Name+"','"+DOB+"','"+Address+"','"+Phone+"','"+Email+"','"+Degree+"','"+EMPID+"');";
                    conn.stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Details added successfully");
                    setVisible(false);
                    new Home();

                }catch(Exception e){
                    e.getMessage();
                }
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        new AddEmployee();
    }
}
