package zadanie5;

import javax.swing.*;
import java.awt.*;


public class Main
{
    public static void main(String[] args)
    {
        final int width = 1000, height = 1000;
        JFrame frame = new JFrame("zadanie 5");
        JLabel statusLabel = new JLabel("informacje o zdarzeniach myszy");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        DrawingArea area = new DrawingArea(statusLabel);

        frame.setLayout(new BorderLayout());
        frame.add(area, BorderLayout.CENTER);
        frame.add(statusLabel, BorderLayout.SOUTH);

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

