package zadanie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class DrawingPanel extends JPanel
{
    private Rectangle rect;
    private Point draggingPoint;
    private int windowWidth, windowHeight;


    public DrawingPanel(Rectangle rect_, int windowWidth_, int windowHeight_)
    {
        rect = rect_;
        draggingPoint = null;
        windowWidth = windowWidth_; windowHeight = windowHeight_;

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                if (rect.contains(e.getPoint())) draggingPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                draggingPoint = null;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                if (draggingPoint != null)
                {
                    int dx = e.getX() - draggingPoint.x, dy = e.getY() - draggingPoint.y;
                    int newX = rect.x + dx, newY = rect.y + dy;

                    if (checkRectBorders(newX, newY)) return;

                    rect.setLocation(newX, newY);
                    draggingPoint = e.getPoint();
                    repaint();
                }
            }
        });
    }

    private boolean checkRectBorders(int x, int y)
    {
        return x < 0 || x > windowWidth - rect.width || y < 0 || y > windowHeight - rect.height;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
}

