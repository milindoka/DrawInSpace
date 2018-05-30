import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawInSpace {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                final JFrame frame = new JFrame("Draw In Space");

                frame.setUndecorated(true);
                frame.setBackground(new Color(0, 0, 0, 0));
             //   frame.setBounds(0, 0, 400, 400);

                JPanel contentPane = new JPanel(new BorderLayout());
                contentPane.setOpaque(false);
                JLabel label = new JLabel("Drag me !");
                label.setFont(label.getFont().deriveFont(60f));
                //label.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
                contentPane.add(label);
                frame.setContentPane(contentPane);

                FrameDragListener frameDragListener = new FrameDragListener(frame);
                frame.addMouseListener(frameDragListener);
                frame.addMouseMotionListener(frameDragListener);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public static class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }
}