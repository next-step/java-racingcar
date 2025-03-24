package racingcar.view;

import java.util.List;

public class ResultView {
    private static final String PATTERN = "-";

    public void print(List<List<Integer>> result) {
        System.out.println();
        System.out.println("실행 결과");

        for (List<Integer> runResult : result) {
            for (int carPosition : runResult) {
                printPattern(carPosition);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printPattern(int count) {
        System.out.println(PATTERN.repeat(count));
    }
}
