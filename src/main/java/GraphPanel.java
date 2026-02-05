import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphPanel extends JPanel {
    private static final int BAR_WIDTH = 1;
    private static final int PADDING = 10;
    private ArrayList<Integer> numberList = new ArrayList<>();
    private ArrayList<Integer> originalList = new ArrayList<>();
    private StatisticsPanel statisticsPanel;

    public GraphPanel(int upperLimit, StatisticsPanel statisticsPanel) {
        this.originalList = NumberGenerator.generateNumberList(upperLimit);
        this.numberList = new ArrayList<>(originalList);  //copy
        this.statisticsPanel = statisticsPanel;
    }

    public void startSorting(String algorithm) {

        // reset data to unsorted list before sorting
        numberList = new ArrayList<>(originalList);
        repaint();

        new Thread(() -> {

            long startStatisticStopwatch = System.currentTimeMillis();

            switch (algorithm) {
                case "Bubblesort":
                    BubbleSort bubbleSorter = new BubbleSort();
                    bubbleSorter.bubbleSort(numberList,this);
                    break;
                case "Quicksort":
                    QuickSort quickSorter = new QuickSort();
                    quickSorter.quickSort(numberList, 0, numberList.size() - 1, this);
                    break;
                case "Insertionsort":
                    InsertionSort insertionSorter = new InsertionSort();
                    insertionSorter.insertionSort(numberList, this);
                    break;
                case "Selectionsort":
                    SelectionSort selectionSorter = new SelectionSort();
                    selectionSorter.selectionSort(numberList, this);
                    break;
                default:
                    System.out.println("No algorithm selected yet");
                    break;
            }

            long stopStatisticStopWatch = System.currentTimeMillis();
            long timeElapsed = stopStatisticStopWatch - startStatisticStopwatch;

            updateStatistics(algorithm, timeElapsed);

            repaint();

        }).start();
    }
private void updateStatistics(String algorithm, long timeMs) {
        if(statisticsPanel != null) {
            statisticsPanel.displayTime(algorithm, timeMs);
            statisticsPanel.displayListLength(NumberGenerator.DATA_ARRAY_LENGTH);
        }
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (numberList == null || numberList.isEmpty()) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // max height for scaling
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
