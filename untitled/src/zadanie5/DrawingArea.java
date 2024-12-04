package zadanie5;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DrawingArea extends JPanel
{
    private JLabel statusLabel;

    public DrawingArea(JLabel label)
    {
        this.statusLabel = label;

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                statusLabel.setText("Kursor wszedł na obszar rysowania");
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                statusLabel.setText("Kursor opuścił obszar rysowania");
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                statusLabel.setText("Przycisk myszy wciśnięty");
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                statusLabel.setText("Przycisk myszy zwolniony");
            }
        });

        addMouseWheelListener(e -> statusLabel.setText("Użyto kółka myszy"));
    }
}
