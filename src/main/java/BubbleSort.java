import java.util.ArrayList;

public class BubbleSort {
    public BubbleSort(){}

    public ArrayList<Integer> bubbleSort(ArrayList<Integer> data, GraphPanel panel) {
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
}
