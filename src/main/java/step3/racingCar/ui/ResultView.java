package step3.racingCar.ui;

import java.util.ArrayList;
import java.util.Map;

public class ResultView {

    public static void printForward(int num){
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printResult(ArrayList<Integer> result) {
        result.forEach(num -> {
            printForward(num);
        });
    }

    public static void printResultWithName(Map<String, Integer> result){
        result.forEach((name, forwardNum) -> {
            System.out.print(name + " : ");
            printForward(forwardNum);
        });
        System.out.println();
    }
}
