package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printResult(List<Integer> result) {
        for(int i : result) {
            System.out.print("-".repeat(i));
            System.out.println();
        }
        System.out.println();
    }
}
