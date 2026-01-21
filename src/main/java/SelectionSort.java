import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public SelectionSort(){}

    public ArrayList<Integer> selectionSort(ArrayList<Integer> data, GraphPanel panel){
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
        return data;
    }
}
