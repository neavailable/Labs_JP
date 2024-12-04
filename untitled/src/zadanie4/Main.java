package zadanie4;

import javax.swing.*;
import java.awt.*;


public class Main
{
    public static void main(String[] args)
    {
        final int width = 500, height = 500, coordsAndSize = 100;
        JFrame frame = new JFrame("zadanie 4");
        AnimationPanel panel = new AnimationPanel(new Rectangle(coordsAndSize, coordsAndSize, coordsAndSize, coordsAndSize));

        frame.add(panel);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

