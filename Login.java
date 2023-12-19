import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    String token = "";

    Login() {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Login Window");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel with a BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.DARK_GRAY);

        // Create a JLabel for the username
        JLabel userLabel = new JLabel("Username");
        userLabel.setForeground(Color.WHITE);
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create a JTextField for the username input
        JTextField userField = new JTextField();
        userField.setMaximumSize(new Dimension(200, 20));

        // Create a JLabel for the password
        JLabel passLabel = new JLabel("Password");
        passLabel.setForeground(Color.WHITE);
        passLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create a JPasswordField for the password input
        JPasswordField passField = new JPasswordField();
        passField.setMaximumSize(new Dimension(200, 20));

        // Create a JButton for the login button
        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userText = userField.getText().trim();
                String passText = passField.getText().trim();
                try {
                    String response = new Api().getResponse("/login?user=" + userText + "&pass=" + passText);
                    if (response.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Invalid Username or Password", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        token = response;
                        String name = new Api().getResponse("/api/name?token=" + token);
                        ImageIcon icon = new ImageIcon(new Api().getResponse("/api/icon?token=" + token));
                        String bio = new Api().getResponse("/api/bio?token=" + token);
                        new ProfileFrame(name, icon, bio);
                        frame.dispose();
                    }
                } catch (Exception error) {
                    System.out.println("Error: " + error.getMessage());
                }
            }
        });

        // Add the components to the JPanel
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add some space at the top
        panel.add(userLabel);
        panel.add(userField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space between the fields
        panel.add(passLabel);
        panel.add(passField);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add some space between the fields and the button
        panel.add(loginButton);

        // Add the JPanel to the JFrame and make it visible
        frame.add(panel);
        frame.setVisible(true);
    }
}
