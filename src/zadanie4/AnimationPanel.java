package zadanie4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class AnimationPanel extends JPanel
{
    private Rectangle rect;
    private Timer timer;
    private int dx = 10, dy = 10;


    public AnimationPanel(Rectangle rect_)
    {
        rect = rect_;

        addMouseListener
                (
                        new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (rect.contains(e.getPoint()))
                {
                    timer = new Timer
                    (50, ev ->
                        {
                            rect.setLocation(rect.x + dx, rect.y + dy);
                            repaint();
                        }
                    );
                    timer.start();
                }
            }
        }
                );
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
}
