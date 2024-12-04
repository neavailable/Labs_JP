package zadanie1;

import javax.swing.*;
import java.awt.event.*;


public class Main
{
    public static void main(String[] args)
    {
        final int width = 400, height = 100;
        JFrame frame = new JFrame("zadanie 1");
        JTextField textField = new JTextField("zadanie 1");
        textField.setEditable(false);

        textField.addMouseListener
                (
                        new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Kliknięcie na współrzędnych: X=" + e.getX() + ", Y=" + e.getY());
            }
        }
                );

        frame.add(textField);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
