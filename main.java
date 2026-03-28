import javax.swing.*;

public class main {
    public static void main(String[] args) {

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Username"));
        panel.add(usernameField);

        panel.add(Box.createVerticalStrut(10));

        panel.add(new JLabel("Password"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Login",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            boolean stregth = Logic.checkStregth(password, username)

            if (!stregth) {

                String suggestion = Suggest.getSuggestion(password);

                JOptionPane.showMessageDialog(null,
                        "Weak Password ❌\n" + suggestion,
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

            } else {

                JOptionPane.showMessageDialog(null,
                        "Username and Password saved ✅",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}