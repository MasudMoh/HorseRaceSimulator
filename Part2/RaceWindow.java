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

        // Create a JPanel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());


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

        // Event Listener for lanes
        lanes.addActionListener(e -> {
            Integer selectedLanes = (Integer) lanes.getSelectedItem();
            if (selectedLanes != null){
                System.out.println("User selected " + selectedLanes + " lanes.");
                // To test if the action listener works
            }
        });

        // Adds the option to pick the number of lanes on the track with its label onto the panel.
        panel.add(lanesLabel,BorderLayout.WEST);
        panel.add(lanes, BorderLayout.WEST);

        // Label for the lanes ComboBox.
        JLabel trackLengthLabel = new JLabel("Select the length of the track (in meters):");

        // Create a JComboBox to allow the user to select the track's length
        JComboBox<Integer> trackLength = new JComboBox<>();
        trackLength.addItem(20);
        trackLength.addItem(10);
        trackLength.addItem(30);
        trackLength.addItem(40);

        // Event Listener for trackLength
        trackLength.addActionListener(e -> {
            String selectedLength = (String) trackLength.getSelectedItem();
            System.out.println("User selected a track length of " + trackLength + "m.");
            // To test if the action listener works
        });

        // Adds the option to pick the track's lengths onto the panel with its label.
        panel.add(trackLengthLabel, BorderLayout.WEST);
        panel.add(trackLength, BorderLayout.WEST);

        // Label for the track's shape.
        JLabel trackShapeLabel = new JLabel("Select the shape of the track:");

        // ComboBox for the track's shape
        JComboBox<String> trackShape = new JComboBox<>();
        trackShape.addItem("Straight");
        trackShape.addItem("Oval");
        trackShape.addItem("Figure-eight");

        // Event Listener for trackShape
        trackShape.addActionListener(e -> {
            String selectedTrackShape = (String) trackShape.getSelectedItem();
            System.out.println("User selected the track shape of " + trackShape + ".");
            // To test if the action listener works
        });

        // Adds the option to pick the track's shape with its label onto the panel.
        panel.add(trackShapeLabel, BorderLayout.WEST);
        panel.add(trackShape, BorderLayout.WEST);


        // Label for the track's weather condition.
        JLabel weatherConditionLabel = new JLabel("Select the weather condition of the track:");

        // ComboBox for the track's weather
        JComboBox<String> weatherCondition = new JComboBox<>();
        weatherCondition.addItem("Normal");
        weatherCondition.addItem("Muddy");
        weatherCondition.addItem("Icy");

        // Event Listener for weatherCondition
        weatherCondition.addActionListener(e -> {
            String selectedWeatherCondition = (String) weatherCondition.getSelectedItem();
            System.out.println("User selected the track condition of " + weatherCondition + ".");
            // To test if the action listener works
        });

        // Adds the option to pick the track's condition with its label onto the panel.
        panel.add(weatherConditionLabel, BorderLayout.WEST);
        panel.add(weatherCondition, BorderLayout.WEST);



        // Label for the horse's customisation section.
        JLabel HorseSectionLabel = new JLabel("Horse customisation");

        panel.add(HorseSectionLabel, BorderLayout.EAST);

        // Label for the horse's breeds section.
        JLabel horseBreedLabel = new JLabel("Select the horses ");

        // ComboBox for the horse's breed
        JComboBox<String> horseBreed = new JComboBox<>();
        weatherCondition.addItem("Thoroughbred");
        weatherCondition.addItem("Arabian");
        weatherCondition.addItem("Quarter");

        // Event Listener for horseBreed
        horseBreed.addActionListener(e -> {
            String selectedBreed = (String) horseBreed.getSelectedItem();
            System.out.println("User selected the track condition of " + horseBreed + ".");
            // To test if the action listener works
        });

        // Adds the option to pick the track's shape with its label onto the panel.
        panel.add(horseBreedLabel, BorderLayout.EAST);
        panel.add(horseBreed, BorderLayout.EAST);





        // All default values for now to get the layout of the window
        /** panel.add(new JTextField("TextField 7"));
        panel.add(new JTextField("TextField 8"));
        panel.add(new JTextField("TextField 9"));
        panel.add(new JTextField("TextField 10"));
        panel.add(new JTextField("TextField 11"));
        panel.add(new JTextField("TextField 12"));
        panel.add(new JTextField("TextField 13"));
        panel.add(new JTextField("TextField 14"));
        panel.add(new JTextField("TextField 15"));
        panel.add(new JTextField("TextField 16"));
        **/
        // Submit button to start the race.
        JButton submitButton = new JButton("Start Race");

        submitButton.addActionListener(e -> {
            // Get values from input fields
            Integer selectedLanes = (Integer) lanes.getSelectedItem(); // Get the selected number of lanes.
            Integer selectedLength = (Integer) trackLength.getSelectedItem();// Get the selected track length.
            String selectedTrackShape = (String) trackShape.getSelectedItem();// Get the selected shape of the track.
            String selectedWeatherCondition = (String) weatherCondition.getSelectedItem();// Get the selected weather condition of the track.
            String selectedHorseBreed = (String) horseBreed.getSelectedItem();// Get the selected breed for the horse.



            // Show a message dialogue with the inputs
            JOptionPane.showMessageDialog(frame, "Starting race with the track condition " + selectedWeatherCondition);

            try {

                if (selectedLanes != null && selectedLength !=null && selectedTrackShape != null ){
                    // Create a Race object with the gathered inputs
                    Race race = new Race(selectedLength, selectedLanes, selectedTrackShape, selectedWeatherCondition);
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

        panel.add(submitButton,BorderLayout.SOUTH);

        // Layout & components
        // JLabel welcomeLabel = new JLabel("🏇 Welcome to the Horse Race!", SwingConstants.CENTER);
        //frame.add(welcomeLabel);
        frame.add(panel);
        frame.setVisible(true);
    }
}
