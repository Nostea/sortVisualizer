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
}
