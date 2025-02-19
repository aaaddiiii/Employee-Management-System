import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);
        setLocation(200,50);
        setSize(1170, 650);
        setLayout(null);
        setVisible(true);
        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(260, 300, 700, 37); // Position and size of the progress bar
        progressBar.setStringPainted(true); // Display percentage text
        image.add(progressBar);
     try {
        for (int i = 0; i <= 100; i++) {
            progressBar.setValue(i); // Update progress bar value
            Thread.sleep(10); // Pause for 50ms to simulate loading
        }

        setVisible(false); // Hide splash screen after loading
        new Login(); // Open the login screen
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public static void main(String[] args) {
        new Splash();
    }
}
