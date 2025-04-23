import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RaceWindow {

    public RaceWindow() {
        // Create a JFrame
        JFrame frame = new JFrame("Horse Race Simulator");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center on screen

        // Create a JPanel with GridLayout
        JPanel panel = new JPanel(new GridLayout(4, 4)); // 4 rows, 3 columns

        // All default values for now to get the layout of the window
        panel.add(new JTextField("TextField 1"));
        panel.add(new JTextField("TextField 2"));
        panel.add(new JTextField("TextField 3"));
        panel.add(new JTextField("TextField 4"));
        panel.add(new JTextField("TextField 5"));
        panel.add(new JTextField("TextField 6"));
        panel.add(new JTextField("TextField 7"));
        panel.add(new JTextField("TextField 8"));
        panel.add(new JTextField("TextField 9"));
        panel.add(new JTextField("TextField 10"));
        panel.add(new JTextField("TextField 11"));
        panel.add(new JTextField("TextField 12"));
        panel.add(new JTextField("TextField 13"));
        panel.add(new JTextField("TextField 14"));
        panel.add(new JTextField("TextField 15"));
        panel.add(new JTextField("TextField 16"));


        // Layout & components
        // JLabel welcomeLabel = new JLabel("🏇 Welcome to the Horse Race!", SwingConstants.CENTER);
        //frame.add(welcomeLabel);
        frame.add(panel);
        frame.setVisible(true);
    }
}
