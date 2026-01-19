import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TestPanel extends JPanel {
    private ArrayList<Integer> numberList = new ArrayList<>();
    private static final int BAR_WIDTH = 1;
    private static final int PADDING = 10;

    public TestPanel(int upperLimit) {
        this.numberList = NumberGenerator.generateNumberList(upperLimit);
    }

    //panel neuzeichnen bei neuen Daten
    public void repaintData(ArrayList<Integer>numberList) {
        this.numberList = numberList;
        repaint();
    }
    public void startSorting() {
        new Thread(() -> {
            SortingAlgorithms.selectionSort(numberList, this);
        }).start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (numberList == null || numberList.isEmpty()) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // maximalhöhe für Skalierung
        int maxHeightValue = 0;
        for (int value : numberList) {
            if (value > maxHeightValue) {
                maxHeightValue = value;
            }
        }

        int panelHeight = getHeight();
        int startX = PADDING;

        for (int i = 0; i < numberList.size(); i++) {
            int barHeight = (int) ((double) numberList.get(i) / maxHeightValue * panelHeight);
            int x = startX + i * BAR_WIDTH;
            int y = getHeight() - barHeight;

            g2d.setColor(Color.WHITE);
            g2d.fillRect(x, y, BAR_WIDTH, barHeight);

        }

    }

}
