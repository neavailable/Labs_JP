package zadanie3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main
{
    public static void main(String[] args)
    {
        int width = 400, height = 100;
        JFrame frame = new JFrame("zadanie 4");
        JTextField textField = new JTextField();

        textField.addKeyListener
                (
                        new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e)
            {
                switch (e.getKeyChar())
                {
                    case 'A':
                        textField.setForeground(Color.RED);
                        break;
                    case 'B':
                        textField.setForeground(Color.BLUE);
                        break;
                    case 'C':
                        textField.setText("");
                        break;
                }
            }
        });

        frame.add(textField);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
