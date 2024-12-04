package zadanie5;

import javax.swing.*;
import java.awt.*;


public class Main
{
    public static void main(String[] args)
    {
        final int width = 500, height = 500;
        JFrame frame = new JFrame("zadanie 5");
        JLabel statusLabel = new JLabel("Informacje o zdarzeniach myszy");
        DrawingArea area = new DrawingArea(statusLabel);

        frame.setLayout(new BorderLayout());
        frame.add(area, BorderLayout.CENTER);
        frame.add(statusLabel, BorderLayout.SOUTH);

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

