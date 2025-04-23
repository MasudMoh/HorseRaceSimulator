import javax.swing.*;

public class RaceWindow extends JFrame {

    public RaceWindow() {
        setTitle("Horse Race Simulator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // Layout & components
        JLabel welcomeLabel = new JLabel("🏇 Welcome to the Horse Race!", SwingConstants.CENTER);
        add(welcomeLabel);
    }
}