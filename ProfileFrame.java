
// Import swing components
import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.*;

// Create a class that extends JFrame
public class ProfileFrame extends JFrame {

    // Declare swing components as instance variables
    private JLabel nameLabel, photoLabel, bioLabel;
    private JButton editButton, closeButton;

    // Constructor for the profile frame
    public ProfileFrame(String name, ImageIcon photo, String bio) {
        // Set the title, size, layout, and closability of the frame
        setSize(600, 400);
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        // Create and initialize the swing components
        nameLabel = new JLabel(name, JLabel.CENTER);
        photoLabel = new JLabel(photo, JLabel.CENTER);
        bioLabel = new JLabel(bio, JLabel.CENTER);
        closeButton = new JButton("Close");

        // Add action listeners to the buttons
        closeButton.addActionListener(e -> closeFrame());

        // Add the components to the frame
        add(nameLabel, BorderLayout.NORTH);
        add(photoLabel, BorderLayout.CENTER);
        add(bioLabel, BorderLayout.SOUTH);
        add(closeButton, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    // Method to close the frame
    private void closeFrame() {
        dispose();
    }
}
