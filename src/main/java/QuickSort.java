import java.util.ArrayList;

public class QuickSort {
    public QuickSort() {
    }

    static int partition(ArrayList<Integer> data, int low, int high, GraphPanel panel) {
        int pivot = data.get(high);

        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (data.get(j) <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = data.get(i);
                data.set(i, data.get(j));
                data.set(j, temp);

                // Animation nach jedem Tausch
                PaintingUtility.repaintPanel(panel);
            }
        }

        // swapped the pivot element with the greater element specified by i
        int temp = data.get(i + 1);
        data.set(i + 1, data.get(high));
        data.set(high, temp);

        PaintingUtility.repaintPanel(panel); // anim on pivot switch

        return (i + 1); // return the position from where partition is done
    }

    public void quickSort(ArrayList<Integer> data, int low, int high, GraphPanel panel) {
        if (low < high) {

            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pi = partition(data, low, high, panel);

            // recursive call on the left of pivot
            quickSort(data, low, pi - 1, panel);

            // recursive call on the right of pivot
            quickSort(data, pi + 1, high, panel);
        }
    }

}

