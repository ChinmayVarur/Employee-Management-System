/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emplyoee.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author chinmayvarur
 */
public class ViewEmployee extends JFrame implements ActionListener {
    
    JTable table;
    Choice choice;
    JButton searchButton, update, back;
    
    public ViewEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        table = new JTable();
        JLabel search = new JLabel("Search by EmpID");
        search.setFont(new Font("serif", Font.BOLD,20));
        search.setBounds(20,20, 180, 30);
        add(search);
        
        choice = new Choice();
        choice.setBounds(200, 20, 200, 30);
        choice.add("Select ID");
        add(choice);
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("select * from employee");
            while(rs.next()){
                choice.add(rs.getString("ID"));
            }
            
        }catch(Exception e){
            e.getMessage();
        }
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.getMessage();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        searchButton = new JButton("Seacrh");
        searchButton.setBounds(20, 70, 80, 20);
        searchButton.addActionListener(this);
        add(searchButton);
        
        update = new JButton("Update");
        update.setBounds(120, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(220, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == searchButton){
            String query = "select * from employee where ID = '"+choice.getSelectedItem()+"'";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.stmt.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.getMessage();
            }
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new UpdateEmployee(choice.getSelectedItem() );
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args) {
        
        new ViewEmployee();
    }
}
