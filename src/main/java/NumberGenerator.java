import java.util.ArrayList;
import java.util.Collections;

public class NumberGenerator {
    public static final int DATA_ARRAY_LENGTH = 1250;

    public NumberGenerator(){
    }

    public static ArrayList<Integer> generateNumberList(int upperLimit) {
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i = 1; i <= upperLimit; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        return numberList;
    }

    public static ArrayList<Integer> generateSortedNumberList(int upperLimit) {
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i = 1; i <= upperLimit; i++) {
            numberList.add(i);
        }
        return numberList;
    }

    public static ArrayList<Integer> generateReverseNumberList (int upperLimit) {
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i = upperLimit; i >= 1; i--) {
            numberList.add(i);
        }
        return numberList;
    }

}
