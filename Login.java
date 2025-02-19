import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back;
    Login(){
        JLabel  username = new JLabel("Username :");
        username.setForeground(Color.WHITE);
        username.setBounds(40,20,100,30);
        username.setFont(new Font("Serif",Font.BOLD,20));
        add(username);
        tusername =new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);
        JLabel  password = new JLabel("Password :");
        password.setBounds(40,60,100,30);
        password.setFont(new Font("Serif",Font.BOLD,20));
        password.setForeground(Color.WHITE);


        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,60,150,30);
        add(tpassword);
        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        back = new JButton("BACK");
        back.setBounds(350,140,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/admin.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,600);
        add(img);
        setSize(600,600);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try{
                String username = tusername.getText();
                char[] passwordChars = tpassword.getPassword();
                String password = new String(passwordChars);
                conn conn = new conn();
                System.out.println("connected to database");
                //String query = "select *from login where username ='"+username+"' and password ='"+password+"'";
                String query = "SELECT * FROM login1 WHERE username ='" + username + "' AND password ='" + password + "'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                System.out.println("hh");
                if(resultSet.next()){
                   setVisible(false);
                   new home();

                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }


            }catch(Exception l){
                l.printStackTrace();
            }

        } else if (e.getSource() == back) {
            System.exit(700);

        }
    }
    public static void main(String[] args){
        new Login();
    }
}
