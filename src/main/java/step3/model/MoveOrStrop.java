package step3.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class MoveOrStrop {
    private ArrayList<String> inputCarList;

    public MoveOrStrop(ArrayList<String> inputCarList) {
        this.inputCarList = inputCarList;
    }

    public ArrayList<String> moveOrStop() {
        for (int i = 0; i < inputCarList.size(); i++) {
            inputCarList.set(i, biggerThanFour(inputCarList.get(i)));
        }
        return inputCarList  ;
    }

    public String biggerThanFour(String input) {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            return input + "-";
        }
        return input;
    }
}
