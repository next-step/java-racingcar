package racingcar.ui;

import java.util.List;

public class ResultView {

    public static void print(List<List<Integer>> result) {
        System.out.println("\n실행 결과");

        int round = 1;
        for (List<Integer> positions : result) {
            System.out.println("=== ROUND " + round++ + "===");
            printRoundResult(positions);
        }
    }

    private static void printRoundResult(List<Integer> positions) {
        for (Integer position : positions) {
            printPosition(position);
        }
    }

    private static void printPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

}
