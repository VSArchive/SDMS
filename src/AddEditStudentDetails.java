import javax.swing.*;
import java.awt.event.ItemEvent;

public class AddEditStudentDetails extends JFrame {
    private JTextField nameField;
    private JTextField regNoField;
    private JTextField rollNoField;
    private JTextField semField;
    private JTextField emailField;
    private JPanel addEditPanel;
    private JTextField subject1Field;
    private JTextField subject2Field;
    private JTextField subject3Field;
    private JTextField subject4Field;
    private JTextField subject5Field;
    private JTextField subject6Field;
    private JTextField subject7Field;
    private JTextField subject8Field;
    private JTextField subject9Field;
    private JComboBox semSelection;
    private JLabel subject1Label;
    private JLabel subject2Label;
    private JLabel subject3Label;
    private JLabel subject4Label;
    private JLabel subject5Label;
    private JLabel subject6Label;
    private JLabel subject7Label;
    private JLabel subject8Label;
    private JLabel subject9Label;
    private JButton saveGradesButton;
    private JButton saveButton;
    private JLabel errorLabel;
    private JLabel successLabel;

    AddEditStudentDetails() {

        semSelection.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int selected = semSelection.getSelectedIndex();
                setLabels(selected);
            }
        });

        setContentPane(addEditPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setTitle("SDMS");
        setIconImage(new ImageIcon("assets/logo.png").getImage());
        setVisible(true);
    }

    private void setLabels(int selected) {
        subject1Label.setVisible(true);
        subject2Label.setVisible(true);
        subject3Label.setVisible(true);
        subject4Label.setVisible(true);
        subject5Label.setVisible(true);
        subject6Label.setVisible(true);
        subject7Label.setVisible(true);
        subject8Label.setVisible(true);
        subject9Label.setVisible(true);
        subject1Field.setVisible(true);
        subject2Field.setVisible(true);
        subject3Field.setVisible(true);
        subject4Field.setVisible(true);
        subject5Field.setVisible(true);
        subject6Field.setVisible(true);
        subject7Field.setVisible(true);
        subject8Field.setVisible(true);
        subject9Field.setVisible(true);
        if (selected == 0) {
            subject1Label.setText("MA 101");
            subject2Label.setText("PH 101");
            subject3Label.setText("EC 101");
            subject4Label.setText("CS 101");
            subject5Label.setText("HU 101");
            subject6Label.setText("HU 102");
            subject7Label.setText("CS 111");
            subject8Label.setText("EC 111");
            subject9Label.setVisible(false);
            subject9Field.setVisible(false);
        } else if (selected == 1) {
            subject1Label.setText("CS 201");
            subject2Label.setText("EC 201");
            subject3Label.setText("CS 202");
            subject4Label.setText("CS 203");
            subject5Label.setText("HU 201");
            subject6Label.setText("EC 211");
            subject7Label.setText("CS 211");
            subject8Label.setText("CS 212");
            subject9Label.setVisible(false);
            subject9Field.setVisible(false);
        } else if (selected == 2) {
            subject1Label.setText("MA 301");
            subject2Label.setText("CS 301");
            subject3Label.setText("CS 302");
            subject4Label.setText("CS 303");
            subject5Label.setText("HU 301");
            subject6Label.setText("CS 311");
            subject7Label.setText("CS 312");
            subject8Label.setText("CS 313");
            subject9Label.setVisible(false);
            subject9Field.setVisible(false);
        } else if (selected == 3) {
            subject1Label.setText("CS 401");
            subject2Label.setText("CS 402");
            subject3Label.setText("CS 403");
            subject4Label.setText("EC 401");
            subject5Label.setText("EC 402");
            subject6Label.setText("CS 411");
            subject7Label.setText("CS 412");
            subject8Label.setText("CS 413");
            subject9Label.setVisible(false);
            subject9Field.setVisible(false);
        } else if (selected == 4) {
            subject1Label.setText("CS 501");
            subject2Label.setText("CS 502");
            subject3Label.setText("EC 501");
            subject4Label.setText("Elective 1");
            subject5Label.setText("HU 501");
            subject6Label.setText("CS 511");
            subject7Label.setText("EC 511");
            subject8Label.setText("CS 591");
            subject9Label.setVisible(false);
            subject9Field.setVisible(false);
        } else if (selected == 5) {
            subject1Label.setText("CS 601");
            subject2Label.setText("CS 602");
            subject3Label.setText("CS 603");
            subject4Label.setText("CS 604");
            subject5Label.setText("Elective 2");
            subject6Label.setText("CS 611");
            subject7Label.setText("CS 612");
            subject8Label.setText("CS 613");
            subject9Label.setText("CS 614");
            subject9Field.setVisible(true);
        } else if (selected == 6) {
            subject1Label.setText("CS 701");
            subject2Label.setText("CS 702");
            subject3Label.setText("Elective 3");
            subject4Label.setText("Elective 4");
            subject5Label.setText("CS 711");
            subject6Label.setText("CS 791");
            subject7Label.setVisible(false);
            subject8Label.setVisible(false);
            subject9Label.setVisible(false);
            subject7Field.setVisible(false);
            subject8Field.setVisible(false);
            subject9Field.setVisible(false);
        } else if (selected == 7) {
            subject1Label.setText("Elective 5");
            subject2Label.setText("Elective 6");
            subject3Label.setText("Elective 7");
            subject4Label.setText("CS 891");
            subject5Label.setText("CS 892");
            subject6Label.setVisible(false);
            subject7Label.setVisible(false);
            subject8Label.setVisible(false);
            subject9Label.setVisible(false);
            subject6Field.setVisible(false);
            subject7Field.setVisible(false);
            subject8Field.setVisible(false);
            subject9Field.setVisible(false);
        }
    }


}
