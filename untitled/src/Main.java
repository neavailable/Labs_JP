import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.concurrent.ExecutionException;

public class Main {
    private JFrame frame;
    private JLabel imageLabel;
    private BufferedImage image;
    private final Object imageLock = new Object(); // Synchronizacja dla obrazu

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public Main() {
        frame = new JFrame("Live Image Processing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        JButton loadButton = new JButton("Load Image");
        JButton grayscaleButton = new JButton("Grayscale Effect");
        JButton cancelButton = new JButton("Cancel Operation");

        panel.add(loadButton);
        panel.add(grayscaleButton);
        panel.add(cancelButton);

        imageLabel = new JLabel();
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        loadButton.addActionListener(e -> loadImage());
        grayscaleButton.addActionListener(e -> applyGrayscaleEffect());
        cancelButton.addActionListener(e -> cancelCurrentOperation());

        frame.setVisible(true);
    }

    private SwingWorker<Void, Void> currentWorker;

    private void loadImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            currentWorker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    BufferedImage loadedImage = ImageIO.read(file);
                    synchronized (imageLock) {
                        image = loadedImage;
                    }
                    return null;
                }

                @Override
                protected void done() {
                    try {
                        get(); // Wywołanie w celu sprawdzenia wyjątków
                        synchronized (imageLock) {
                            imageLabel.setIcon(new ImageIcon(image));
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        JOptionPane.showMessageDialog(frame, "Error loading image: " + e.getMessage());
                    }
                }
            };
            currentWorker.execute();
        }
    }

    private void applyGrayscaleEffect() {
        if (image == null) {
            JOptionPane.showMessageDialog(frame, "No image loaded.");
            return;
        }

        currentWorker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                BufferedImage grayscaleImage;
                synchronized (imageLock) {
                    grayscaleImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
                    for (int y = 0; y < image.getHeight(); y++) {
                        for (int x = 0; x < image.getWidth(); x++) {
                            int rgb = image.getRGB(x, y);
                            int r = (rgb >> 16) & 0xFF;
                            int g = (rgb >> 8) & 0xFF;
                            int b = rgb & 0xFF;
                            int gray = (r + g + b) / 3;
                            int newRgb = (gray << 16) | (gray << 8) | gray | (0xFF << 24);
                            grayscaleImage.setRGB(x, y, newRgb);
                        }
                    }
                }
                synchronized (imageLock) {
                    image = grayscaleImage;
                }
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    synchronized (imageLock) {
                        imageLabel.setIcon(new ImageIcon(image));
                    }
                } catch (InterruptedException | ExecutionException e) {
                    JOptionPane.showMessageDialog(frame, "Error applying effect: " + e.getMessage());
                }
            }
        };
        currentWorker.execute();
    }

    private void cancelCurrentOperation() {
        if (currentWorker != null && !currentWorker.isDone()) {
            currentWorker.cancel(true);
        }
    }
}
