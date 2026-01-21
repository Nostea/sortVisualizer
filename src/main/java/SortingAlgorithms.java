import java.util.ArrayList;
import java.util.Collections;


public class SortingAlgorithms {
    public SortingAlgorithms() {
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> data, GraphPanel panel) {

        for (int i = 0; i < data.size() - 1; i++) {
            boolean isSwapped = false;

            for (int j = 0; j < data.size() - i - 1; j++) {
                if (data.get(j) > data.get(j + 1)) {

                    int valueA = data.get(j);
                    int valueB = data.get(j + 1);

                    data.set(j, valueB);
                    data.set(j + 1, valueA);
                    isSwapped = true;
                }
            }

            if (!isSwapped) {
                break;
            }

            PaintingUtility.repaintPanel(panel);
        }
        return data;
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> data, GraphPanel panel) {

        for (int i = 0; i < data.size(); i++) {
            int minIndex = i;
            for (int j = i; j < data.size(); j++) { // loop 1 time less each loop
                if (data.get(j) < data.get(minIndex)) {
                    minIndex = j;

                    int minValuePosition = data.get(j);
                    Collections.swap(data, j, minValuePosition);
                }
            }
            PaintingUtility.repaintPanel(panel);
        }

        /* FALSCH
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.size(); j++) { // loop 1 time less each loop
                if (data.get(j) > Collections.min(data)) {
                    int minValue = Collections.min(data);
                    int minValuePosition = data.indexOf(minValue);

                    //int currentValue = data.get(j);
                    //int smallerValue = data.get(minValuePosition);
                    Collections.swap(data, j, minValuePosition);
                }
            }
            PaintingUtility.repaintPanel(panel);
        }
        */
        return data;
    }

}
