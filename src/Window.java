import javax.swing.*;
import java.awt.*;


public class Window
{
    JFrame frame;
    JPanel panel;
    JLabel label1, label2;
    JTextField textField1;
    JPasswordField passwordField;
    JButton buttonShowAll, buttonChangeSize, buttonMove, buttonEnterName;
    final Color [] colors;
    final String [] colorsName;
    JComboBox changeColorBox;
    JTextArea textArea;

    public Window()
    {
        frame = new JFrame("dynamiczne zmiany komponentów");
        colors = new Color[] { Color.ORANGE, Color.PINK, Color.LIGHT_GRAY };
        colorsName = new String[] { "żółty", "różowy", "szary" };
        panel = new JPanel();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel.setBackground(colors[0]);
        panel.setLayout(null);

        label1 = new JLabel("imię:");
        label1.setBounds(20, 20, 50, 20);
        textField1 = new JTextField(20);
        textField1.setBounds(80, 20, 150, 20);

        label2 = new JLabel("hasło:");
        label2.setBounds(20, 60, 50, 20);
        passwordField = new JPasswordField(20);
        passwordField.setBounds(80, 60, 150, 20);

        buttonShowAll = new JButton("wyświetl");
        buttonShowAll.setBounds(20, 100, 150, 30);

        changeColorBox = new JComboBox(colorsName);
        changeColorBox.setBounds(20, 140, 150, 30);

        buttonChangeSize = new JButton("zmień rozmiar");
        buttonChangeSize.setBounds(20, 180, 150, 30);

        buttonMove = new JButton("przesuń");
        buttonMove.setBounds(20, 220, 150, 30);

        buttonEnterName = new JButton("wprowadź imię");
        buttonEnterName.setBounds(20, 260, 150, 30);

        textArea = new JTextArea();
        textArea.setBounds(250, 20, 300, 200);
        textArea.setEditable(false);
    }

    private void ShowAll()
    {
        String name = textField1.getText();
        String passcode = new String(passwordField.getPassword());

        textArea.setText("imię: " + name + "\nhasło: " + passcode);
    }

    private void ChangeColor()
    {
        Color selectedColor = colors[changeColorBox.getSelectedIndex()];

        if (selectedColor != null) panel.setBackground(selectedColor);
    }

    private void ChangeSize()
    {
        String newSize = JOptionPane.showInputDialog(frame, "podaj nowy rozmiar okna (szerokość,wysokość):");
        if (newSize != null && newSize.contains(","))
        {
            try
            {
                String[] dimensions = newSize.split(",");
                int width = Integer.parseInt(dimensions[0].trim());
                int height = Integer.parseInt(dimensions[1].trim());
                frame.setSize(width, height);
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(frame, "niepoprawny format! Podaj liczby oddzielone przecinkiem.");
            }
        }
    }

    private void MoveComponent()
    {
        int x = (int) (Math.random() * (frame.getWidth() - buttonMove.getWidth()));
        int y = (int) (Math.random() * (frame.getHeight() - buttonMove.getHeight()));
        buttonMove.setLocation(x, y);
    }

    private void EnterName()
    {
        String imie = JOptionPane.showInputDialog(frame, "podaj swoje imię:", "wprowadź imię", JOptionPane.PLAIN_MESSAGE);
        if (imie != null && !imie.isEmpty())
        {
            JOptionPane.showMessageDialog(frame, "hejka, " + imie + "!", "powitanie", JOptionPane.INFORMATION_MESSAGE);
            textArea.setText("hejka, " + imie + "!");
        }
    }

    public void AddComponentsToWindow()
    {
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(passwordField);
        panel.add(buttonShowAll);
        panel.add(changeColorBox);
        panel.add(buttonChangeSize);
        panel.add(buttonMove);
        panel.add(buttonEnterName);
        panel.add(textArea);

        buttonShowAll.addActionListener(e -> ShowAll());
        changeColorBox.addActionListener(e -> ChangeColor());
        buttonChangeSize.addActionListener(e -> ChangeSize());
        buttonMove.addActionListener(e -> MoveComponent());
        buttonEnterName.addActionListener(e -> EnterName());

        frame.add(panel);
        frame.setVisible(true);
    }
}