public class MainGUI {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            RaceWindow window = new RaceWindow();
            window.setVisible(true);
        });
    }
}