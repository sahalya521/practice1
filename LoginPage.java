import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    private JTextField userTextField;
    private JPasswordField passField;
    private JButton loginButton;
    private JLabel statusLabel;

    public LoginPage() {
        setTitle("Login Page");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel userLabel = new JLabel("Username:");
        userTextField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        passField = new JPasswordField();
        loginButton = new JButton("Login");
        statusLabel = new JLabel("");

        loginButton.addActionListener(this);

        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel(""));
        panel.add(loginButton);
        panel.add(new JLabel(""));
        panel.add(statusLabel);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userTextField.getText();
        String password = new String(passField.getPassword());

        if (username.equals("admin") && password.equals("password123")) {
            statusLabel.setText("Login successful!");
            statusLabel.setForeground(Color.GREEN);
        } else {
            statusLabel.setText("Invalid credentials.");
            statusLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginPage lp = new LoginPage();
            lp.setVisible(true);
        });
    }
}