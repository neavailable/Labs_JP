package zadanie2;

import javax.swing.*;
import java.awt.*;


public class Main
{
    public static void main(String[] args)
    {
        final int width = 500, height = 500, coordsAndSize = 100;
        JFrame frame = new JFrame("zadanie 4");
        DrawingPanel drawingPanel = new DrawingPanel(new Rectangle(coordsAndSize, coordsAndSize, coordsAndSize, coordsAndSize), width, height);

        frame.add(drawingPanel);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
