package step3.util;

import java.util.List;

public class OutputView {
    public static void printResult(List<List<Integer>> result) {
        System.out.println("실행결과");
        for (List<Integer> carPositions : result) {
            for (int i = 0; i < carPositions.size(); i++) {
                System.out.println( "-".repeat(carPositions.get(i)));
            }
            System.out.println();
        }
    }
}
