package zadanie6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


class DrawingAreaPanel extends JPanel
{
    private Color color;
    private int [] coorsdAndSize;
    private enum shapes {rectangle, circle};
    shapes shape;

    public DrawingAreaPanel(int [] coorsdAndSize_)
    {
        shape = shapes.rectangle;
        color = Color.RED;
        coorsdAndSize = coorsdAndSize_;
        setFocusable(true);

        addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyChar() == 'a') color = Color.GREEN;

                else if (e.getKeyChar() == 'b') color = Color.BLUE;

                else if (e.isControlDown()) chooseShape();

                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                color = Color.RED;
                repaint();
            }
        });
    }

    private void chooseShape()
    {
        if (shape == shapes.rectangle) shape = shapes.circle;
        else shape = shapes.rectangle;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(color);

        if (shape == shapes.rectangle) g.fillRect(coorsdAndSize[0], coorsdAndSize[1], coorsdAndSize[2], coorsdAndSize[3]);
        else g.fillOval(coorsdAndSize[0], coorsdAndSize[1], coorsdAndSize[2], coorsdAndSize[3]);
    }
}
