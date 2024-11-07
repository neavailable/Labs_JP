import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel label1 = new JLabel("Imię:");
        JTextField textField1 = new JTextField(20);
        JLabel label2 = new JLabel("Hasło:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton button = new JButton("Pokaż wszystko");
        JTextArea textArea = new JTextArea(5, 30);
        textArea.setEditable(false);

        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(button);
        panel.add(new JScrollPane(textArea));

        frame.add(panel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAll(textField1, passwordField, textArea);
            }
        });

        frame.setVisible(true);
    }

    public static void showAll(JTextField textField, JPasswordField passwordField, JTextArea textArea)
    {
        String imie = textField.getText();
        String haslo = new String(passwordField.getPassword());

        textArea.setText("Imię: " + imie + "\nHasło: " + haslo);
    }
}