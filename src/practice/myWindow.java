package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.io.File; // Add this import statement

public class myWindow extends JFrame
{
    private JLabel heading, clockLabel;
    private Font font = new Font("Orbitron", Font.BOLD, 35);

    myWindow()
    {
        super.setTitle("My-Clock");
        super.setSize(600, 300);
        super.setLocation(200, 100);
        this.createGUI();
        this.startClock();
        super.setVisible(true);
    }

    public void createGUI()
    {
        Font orbitronFont = null;
        try {
            orbitronFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/static/Orbitron-Regular.ttf")).deriveFont(Font.BOLD, 35);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.getContentPane().setBackground(Color.BLACK);
        heading = new JLabel("My Clock");
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.decode("#48FF33"));
        heading.setFont(orbitronFont);

        clockLabel = new JLabel("Clock");
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clockLabel.setForeground(Color.decode("#48FF33"));
        clockLabel.setFont(orbitronFont);

        this.setLayout(new GridLayout(2, 1));
        this.add(heading);
        this.add(clockLabel);
    }

    public void startClock()
    {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateTime = new Date().toLocaleString();
                clockLabel.setText(dateTime);
            }
        });
        timer.start();
    }
}
