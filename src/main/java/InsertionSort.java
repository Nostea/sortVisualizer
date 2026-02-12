import java.util.ArrayList;

public class InsertionSort extends AbstractSortAlgorithm {

    public void insertionSort(ArrayList<Integer> data, GraphPanel panel) {
        //unsorted list: 7,12,9,11,3
        for (int i = 1; i < data.size(); i++) { // i = 0 already sorted
            int key = data.get(i);
            int j = i - 1;
            // if key < data.get(j), key moves one position to left
            // process continues until the condition in while loop is met, element smaller than key
            while (j >= 0 && data.get(j) > key ) {  // order in which conditions are written important!
                data.set(j + 1, data.get(j)); //shift, not swap
                j = j - 1;
                panel.setCurrentSortPosition(j);
                PaintingUtility.repaintPanel(panel);
            }
            data.set(j + 1, key);
        }

    }
}
