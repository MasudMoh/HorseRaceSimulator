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
        JComboBox<Integer> lanes = new JComboBox<>();
        lanes.addItem(2);
        lanes.addItem(3);
        lanes.addItem(4);
        lanes.addItem(5);
        lanes.addItem(6);
        lanes.addItem(7);
        // Label for the lanes ComboBox.
        JLabel lanesLabel = new JLabel("Select number of lanes:");

        lanes.addActionListener(e -> {
            Integer selectedLanes = (Integer) lanes.getSelectedItem();
            if (selectedLanes != null){
                System.out.println("User selected " + selectedLanes + " lanes.");
                // To test if the action listener works
            }
        });

        // Label for the lanes ComboBox.
        JLabel trackLengthLabel = new JLabel("Select the length of the track:");

        // Create a JComboBox to allow the user to select the track's length
        JComboBox<String> trackLength = new JComboBox<>();
        trackLength.addItem("Normal Track");
        trackLength.addItem("Short Track");
        trackLength.addItem("Long Track");

        trackLength.addActionListener(e -> {
            String selectedLength = (String) trackLength.getSelectedItem();
            System.out.println("User selected " + trackLength + " lanes.");
            // To test if the action listener works
        });

        panel.add(lanesLabel);
        panel.add(lanes);

        panel.add(trackLengthLabel);
        panel.add(trackLength);

        // All default values for now to get the layout of the window
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

        // Submit button to start the race.
        JButton submitButton = new JButton("Start Race");

        submitButton.addActionListener(e -> {
            // Get values from input fields
            Integer selectedLanes = (Integer) lanes.getSelectedItem(); // Get the selected number of lanes
            String selectedLength = (String) trackLength.getSelectedItem();

            // Show a message dialog with the inputs
            JOptionPane.showMessageDialog(frame, "Starting race with " + selectedLanes + " lanes! " + selectedLength);

            try {

                if (selectedLanes != null && selectedLength !=null){
                    // Create a Race object with the gathered inputs
                    Race race = new Race(20);
                    race.startRace(); // Start the race
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Please enter valid values for all fields.");
                }
            }
            catch (NumberFormatException ex){
                // Handles an invalid number input
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values.");
            }
        });

        panel.add(submitButton);

        // Layout & components
        // JLabel welcomeLabel = new JLabel("🏇 Welcome to the Horse Race!", SwingConstants.CENTER);
        //frame.add(welcomeLabel);
        frame.add(panel);
        frame.setVisible(true);
    }
}
