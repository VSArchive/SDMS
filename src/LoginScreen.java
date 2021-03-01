import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class LoginScreen extends JFrame {
    private JTextField username;
    private JTextField name;
    private JPasswordField password;
    private JComboBox accountType;
    private JButton loginButton;
    private JButton createAccountButton;
    private JPanel loginPanel;
    private JLabel icon;
    private JLabel errorField;
    private JLabel nameLabel;
    private JLabel orLabel;
    private JButton goBackButton;
    private JTextField regNo;
    private JLabel regNoLabel;

    private final Connection con = new ConnectDB().connection();

    LoginScreen() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isFormFilled()) {
                    loginUser(username.getText(), password.getText());
                }
            }
        });
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.isVisible()) {
                    if (isFormFilled()) {
                        createUser(name.getText(), username.getText(), password.getText(), accountType.getSelectedIndex());
                    }
                } else {
                    errorField.setText("");
                    name.setVisible(true);
                    nameLabel.setVisible(true);
                    regNo.setVisible(true);
                    regNoLabel.setVisible(true);
                    goBackButton.setVisible(true);
                    accountType.setVisible(true);
                    loginButton.setVisible(false);
                    orLabel.setVisible(false);
                }
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorField.setText("");
                name.setVisible(false);
                nameLabel.setVisible(false);
                goBackButton.setVisible(false);
                regNo.setVisible(false);
                regNoLabel.setVisible(false);
                accountType.setVisible(false);
                loginButton.setVisible(true);
                orLabel.setVisible(true);
            }
        });

        accountType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Object item = e.getItem();
                    if (item.toString().equals("Lecturer")) {
                        regNo.setVisible(false);
                        regNoLabel.setVisible(false);
                    } else {
                        regNo.setVisible(true);
                        regNoLabel.setVisible(true);
                    }
                }
            }
        });

        try {
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("assets/logo.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            icon.setIcon(imageIcon);
            icon.setMaximumSize(new Dimension(1, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setContentPane(loginPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setTitle("SDMS");
        setVisible(true);
    }

    private void createUser(String name, String username, String password, int selectedIndex) {
        if (con != null) {
            try {
                boolean isStudent, isAdmin;
                int regNo;
                if (selectedIndex == 1) {
                    isStudent = false;
                    isAdmin = true;
                    regNo = 0;
                } else {
                    isStudent = true;
                    isAdmin = false;
                    regNo = Integer.parseInt(this.regNo.getText());
                }
                Statement statement = con.createStatement();
                String sql = "INSERT INTO login_table(name, username, password, regNo, isStudent, isAdmin) VALUES (" + "'" + name+ "'," + "'" + username+ "'," + "'" + password+ "'," + regNo + "," + isStudent + ","+ isAdmin +")";
                if (statement.executeUpdate(sql) == 1){
                    con.close();
                    dispose();
                    new MainScreen();
                }
            } catch (SQLException throwable) {
                errorField.setText(throwable.getMessage());
            }
        }
    }

    private void loginUser(String username, String password) {

        if (con != null) {
            try {
                Statement statement = con.createStatement();
                String sql = "SELECT password FROM login_table WHERE username="+"'"+username+"'";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    if (resultSet.getString("password").equals(password)){
                        con.close();
                        dispose();
                        new MainScreen();
                        break;
                    }
                }
            } catch (SQLException throwable) {
                errorField.setText(throwable.getMessage());
                throwable.printStackTrace();
            }
        }
    }

    private boolean isFormFilled() {
        if (username.getText().isEmpty()) {
            errorField.setText("Enter Valid User Name");
            return false;
        } else if (password.getPassword().length < 6) {
            errorField.setText("Enter Valid Password");
            return false;
        } else if (name.isVisible() && name.getText().isEmpty()) {
            errorField.setText("Enter Your Name");
            return false;
        } else {
            errorField.setText("");
            return true;
        }
    }
}
