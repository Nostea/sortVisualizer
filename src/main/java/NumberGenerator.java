import java.util.ArrayList;
import java.util.Collections;

public class NumberGenerator {

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
