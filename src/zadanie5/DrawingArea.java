package zadanie5;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class DrawingArea extends JPanel
{
    private JLabel statusLabel;

    public DrawingArea(JLabel label_)
    {
        statusLabel = label_;

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                statusLabel.setText("kursor wszedł na obszar rysowania");
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                statusLabel.setText("kursor opuścił obszar rysowania");
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                statusLabel.setText("przycisk myszy wciśnięty");
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                statusLabel.setText("przycisk myszy zwolniony");
            }
        });

        addMouseWheelListener(e -> statusLabel.setText("użyto kółka myszy"));
    }
}
