package step3.racingCar.ui;

import java.util.ArrayList;

public class ResultView {
    public static void printResult(ArrayList<Integer> result) {
        result.forEach(integer -> {
            for (int i = 0; i < integer; i++) {
                System.out.print("-");
            }
            System.out.println();
        });
    }
}
