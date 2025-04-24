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
        JPanel panel = new JPanel(new GridBagLayout()); // 4 rows, 4 columns

        // Create a JComboBox to allow the user to select how many lanes they want.
        JComboBox<Integer> Lanes = new JComboBox<>();
        Lanes.addItem(2);
        Lanes.addItem(3);
        Lanes.addItem(4);
        Lanes.addItem(5);
        Lanes.addItem(6);
        Lanes.addItem(7);
        // Label for the lanes ComboBox.
        JLabel lanesLabel = new JLabel("Select number of lanes:");

        // Create a JComboBox to allow the user to select the track's length

        // Label for the lanes ComboBox.
        JLabel TrackLengthLabel = new JLabel("Select the length of the track:");

        JComboBox<String> TrackLength = new JComboBox<>();
        TrackLength.addItem("Short Track");
        TrackLength.addItem("Normal Track");
        TrackLength.addItem("Long Track");

        // All default values for now to get the layout of the window
        panel.add(lanesLabel);
        panel.add(Lanes);

        panel.add(TrackLengthLabel);
        panel.add(TrackLength);

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
