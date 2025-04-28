import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class RaceWindow {

    public RaceWindow() {
        // Create a JFrame
        JFrame frame = new JFrame("Horse Race Simulator");
        frame.setSize(1200, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center on screen

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Create a JPanel with BorderLayout
        JPanel panel = new JPanel(new GridLayout(2,6));
        panel.setPreferredSize(new Dimension(1200, 425));
        panel.setBackground(Color.pink);


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
        panel.add(lanesLabel);
        panel.add(lanes);

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
        panel.add(trackLengthLabel);
        panel.add(trackLength);

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
        panel.add(trackShapeLabel);
        panel.add(trackShape);


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
        panel.add(weatherConditionLabel);
        panel.add(weatherCondition);


        JPanel panel2 = new JPanel(new GridLayout(1,1));
        panel2.setPreferredSize(new Dimension(1200, 425));
        panel2.setBackground(Color.cyan);

        // Label for the horse's breeds section.
        JLabel horseBreedLabel = new JLabel("Select the horse's breed");

        // ComboBox for the horse's breed
        JComboBox<String> horseBreed = new JComboBox<>();
        horseBreed.addItem("Thoroughbred");
        horseBreed.addItem("Arabian");
        horseBreed.addItem("Quarter");

        // Event Listener for horseBreed
        horseBreed.addActionListener(e -> {
            String selectedBreed = (String) horseBreed.getSelectedItem();
            System.out.println("User selected the track condition of " + horseBreed + ".");
            // To test if the action listener works
        });
        // This keeps track of how many horses has been created.
        int HorseCounter=0;
        List<Horse> horseArray = new ArrayList<>();

        // Adds the option to pick the track's shape with its label onto the panel.
        panel2.add(horseBreedLabel);
        panel2.add(horseBreed);

        JButton addHorseButton = new JButton("Add Horse");

        addHorseButton.addActionListener(e -> {
            String selectedBreed = (String) horseBreed.getSelectedItem(); // Get the selected number of lanes.
            Integer selectedLength = (Integer) trackLength.getSelectedItem();// Get the selected track length.

            // default name, symbol and confidence ratings
            Horse horse1 = new Horse('♘',"PIPPI LONGSTOCKING",0.4);

            horseArray.add(horse1);


        });



        // Submit button to start the race.
        JButton submitButton = new JButton("Start Race");

        submitButton.addActionListener(e -> {
            // Get values from input fields
            Integer selectedLanes = (Integer) lanes.getSelectedItem(); // Get the selected number of lanes.
            Integer selectedLength = (Integer) trackLength.getSelectedItem();// Get the selected track length.
            String selectedTrackShape = (String) trackShape.getSelectedItem();// Get the selected shape of the track.
            String selectedWeatherCondition = (String) weatherCondition.getSelectedItem();// Get the selected weather condition of the track.
            String[] Horses = (String[]) horseBreed.getSelectedItem();// Get the selected breed for the horse.



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
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.setBackground(Color.orange);
        panel3.setPreferredSize(new Dimension(1200, 50));

        panel3.add(submitButton);


        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.setVisible(true);
    }
}
