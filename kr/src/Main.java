import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main extends JFrame {
    private DrawingPanel drawingPanel;
    private JSlider horizontalSlider;
    private JSlider verticalSlider;
    private JButton huntButton;
    private List<MovingRectangle> rectangles = new ArrayList<>();

    public Main() {
        setTitle("Rectangle Hunting Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Drawing panel
        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        // Sliders panel
        JPanel sliderPanel = new JPanel(new GridLayout(2, 1));

        horizontalSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        horizontalSlider.setMajorTickSpacing(20);
        horizontalSlider.setPaintTicks(true);
        horizontalSlider.setPaintLabels(true);

        verticalSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        verticalSlider.setMajorTickSpacing(20);
        verticalSlider.setPaintTicks(true);
        verticalSlider.setPaintLabels(true);

        sliderPanel.add(new JLabel("Horizontal Aim"));
        sliderPanel.add(horizontalSlider);
        sliderPanel.add(new JLabel("Vertical Aim"));
        sliderPanel.add(verticalSlider);

        // Hunt button
        huntButton = new JButton("Hunt");
        huntButton.addActionListener(e -> huntRectangles());
        sliderPanel.add(huntButton);

        add(sliderPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void huntRectangles() {
        int x = horizontalSlider.getValue();
        int y = verticalSlider.getValue();

        rectangles.removeIf(rect ->
                rect.isHit(x * getWidth() / 100, y * getHeight() / 100)
        );
        drawingPanel.repaint();
    }

    private class DrawingPanel extends JPanel {
        private Point startPoint;

        public DrawingPanel() {
            setBackground(Color.WHITE);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (startPoint == null) {
                        startPoint = e.getPoint();
                    } else {
                        Rectangle rect = createRectangle(startPoint, e.getPoint());
                        MovingRectangle movingRect = new MovingRectangle(rect);
                        rectangles.add(movingRect);
                        movingRect.start();
                        startPoint = null;
                        repaint();
                    }
                }
            });
        }

        private Rectangle createRectangle(Point start, Point end) {
            int x = Math.min(start.x, end.x);
            int y = Math.min(start.y, end.y);
            int width = Math.abs(start.x - end.x);
            int height = Math.abs(start.y - end.y);
            return new Rectangle(x, y, width, height);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (MovingRectangle rect : rectangles) {
                g.setColor(rect.color);
                g.fillRect(rect.rectangle.x, rect.rectangle.y,
                        rect.rectangle.width, rect.rectangle.height);
            }
        }
    }

    private class MovingRectangle extends Thread {
        Rectangle rectangle;
        Color color;
        int dx, dy;

        public MovingRectangle(Rectangle rect) {
            this.rectangle = rect;
            Random random = new Random();
            this.color = new Color(random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256));

            // Random movement direction
            dx = random.nextInt(5) + 1 * (random.nextBoolean() ? 1 : -1);
            dy = random.nextInt(5) + 1 * (random.nextBoolean() ? 1 : -1);
        }

        public boolean isHit(int x, int y) {
            return rectangle.contains(x, y);
        }

        @Override
        public void run() {
            while (true) {
                // Move rectangle
                rectangle.x += dx;
                rectangle.y += dy;

                // Bounce off edges
                if (rectangle.x <= 0 || rectangle.x + rectangle.width >= drawingPanel.getWidth()) {
                    dx = -dx;
                }
                if (rectangle.y <= 0 || rectangle.y + rectangle.height >= drawingPanel.getHeight()) {
                    dy = -dy;
                }

                // Repaint
                SwingUtilities.invokeLater(() -> drawingPanel.repaint());

                // Sleep to control speed
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}