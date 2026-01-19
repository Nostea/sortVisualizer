import java.util.ArrayList;
import java.awt.*;


public class SortingAlgorithms {
    public SortingAlgorithms() {
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> data, TestPanel panel) {

        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = 0; j < data.size() - i - 1; j++) {

                if (data.get(j) > data.get(j + 1)) {

                    int valueA = data.get(j);
                    int valueB = data.get(j + 1);

                    data.set(j, valueB);
                    data.set(j + 1, valueA);
                }


            }
            panel.repaint();


            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return data;
    }
}
