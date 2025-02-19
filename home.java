import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends JFrame implements ActionListener {
    JButton add,view,rem,logout;
    home() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/homelast.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Employee Management system");
        heading.setBounds(320, 50, 400, 40);
        heading.setFont(new Font("Serif", Font.BOLD, 29));
        heading.setForeground(Color.BLACK);
        image.add(heading);

        JLabel dis = new JLabel();
        dis.setBounds(320,90,400,40);
        dis.setBackground(Color.darkGray);
        image.add(dis);

        add = new JButton("Add Employee");
        add.setBounds(75,200, 150, 80);
      //  add.setForeground(Color.WHITE);
     //   add.setBackground(Color.lightGray);
        add.addActionListener(this);
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/homelast.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel image1 = new JLabel(ii3);
        image.add(image1);

        ImageIcon icon = new ImageIcon("icons/add-user.png");
        Image image2 = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); // Scale the image to 30x30
        icon = new ImageIcon(image2); // Create a new ImageIcon from the scaled image
        add.setIcon(icon);
        image.add(add);



        logout = new JButton("LogOut");
        logout.setBounds(75,250,150,40);
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.lightGray);
        logout.addActionListener(this);
        image.add(logout);


        view = new JButton("View Employee");
        view.setBounds(75, 50, 150, 40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.lightGray);
        view.addActionListener(this);
        image.add(view);

        rem = new JButton("Remove Employee");
        rem.setBounds(75, 100, 150, 40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.lightGray);
        rem.addActionListener(this);
        image.add(rem);

        setSize(1120, 630);
        setLocation(250, 100);

        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }
    @Override
        public void actionPerformed (ActionEvent e){
            if (e.getSource() == add) {
                setVisible(false);
                new AddEmployee();
            } else if (e.getSource() == view) {
                new View_Employee();
            } else if (e.getSource() == rem) {
                setVisible(false);
                new RemoveEmployee();
            } else if (e.getSource() == logout) {
                setVisible(false);
                new Login();

            }

    }

    public static void main(String[] args) {
        new home();
    }
}
