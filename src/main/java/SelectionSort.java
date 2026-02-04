import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public SelectionSort(){}

    public ArrayList<Integer> selectionSort(ArrayList<Integer> data, GraphPanel panel){
        for (int i = 0; i < data.size(); i++) {
            int minIndex = i;
            //find smallest element in unsorted Part of array
            for (int j = i + 1; j < data.size(); j++) { // loop 1 time less each loop
                if (data.get(j) < data.get(minIndex)) {
                    minIndex = j;
                }
            }
            //swap after minimum is found in inner loop
            Collections.swap(data, i, minIndex);
            PaintingUtility.repaintPanel(panel);
        }
        return data;
    }
}
