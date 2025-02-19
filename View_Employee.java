import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener {

    JTable table;
    Choice choiceEMP;
    JButton searchbtn, print, update, back;
    JLabel searchImage;

    View_Employee() {
        getContentPane().setBackground(new Color(255, 131, 122));

        // Create a label for the search text
        JLabel search = new JLabel("Search by employee id");
        search.setBounds(20, 20, 150, 20);
        add(search);

        // Add image to the search area
        searchImage = new JLabel(new ImageIcon("icons/viewemployee.jpg"));
        searchImage.setBounds(180, 20, 30, 30); // Adjust the position and size as per your needs
        add(searchImage);

        // Create choice dropdown for employee selection
        choiceEMP = new Choice();
        choiceEMP.setBounds(220, 20, 150, 20);
        add(choiceEMP);

        // Add employee IDs to the dropdown
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                choiceEMP.add(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Table to display employee data
        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        // Search button
        searchbtn = new JButton("Search");
        searchbtn.setBounds(20, 70, 80, 20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        // Print button
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        // Update button
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        // Back button
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        // Set frame properties
        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn) {
            String query = "select * from employee where empId = '" + choiceEMP.getSelectedItem() + "'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == update) {
            setVisible(false);
            // new UpdateEmployee(choiceEMP.getSelectedItem());
        } else {
            setVisible(false);
            new home();
        }
    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
