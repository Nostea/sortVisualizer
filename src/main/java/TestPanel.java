import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPanel extends JPanel {
    private int[] data;
    private static final int BAR_WIDTH = 2;
    private static final int PADDING = 10;

    public TestPanel() {
        this.data = new int[]{5, 12, 8, 15, 3, 20, 7, 18, 10, 14};
    }

    //panel neuzeichnen bei neuen Daten
    public void setData(int[] data) {
        this.data = data;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (data == null || data.length == 0) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // maximalhöhe für Skalierung
        int maxHeightValue = 0;
        for (int value : data) {
            if (value > maxHeightValue) {
                maxHeightValue = value;
            }
        }

        int panelHeight = getHeight();
        int startX = PADDING;

        for (int i = 0; i < data.length; i++) {
            int barHeight = (int) ((double) data[i] / maxHeightValue * panelHeight);
            int x = startX + i * BAR_WIDTH;
            int y = getHeight() - PADDING - barHeight;

            g2d.setColor(Color.WHITE);
            g2d.fillRect(x, y, BAR_WIDTH, barHeight);

        }


    }

}
