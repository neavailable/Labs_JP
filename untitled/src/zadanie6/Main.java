package zadanie6;

import javax.swing.*;


public class Main
{
    public static void main(String[] args)
    {
        final int width = 500, height = 500, arraySize = 4;
        JFrame frame = new JFrame("zadanie 6");

        int [] coordsAndSize = new int[4];
        for (int i = 0; i < arraySize; i++) coordsAndSize[i] = 100;

        DrawingAreaPanel area = new DrawingAreaPanel(coordsAndSize);

        frame.add(area);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

