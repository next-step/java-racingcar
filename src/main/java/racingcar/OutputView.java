package racingcar;

import java.util.List;

public class OutputView {

    public static void printCarTraceUntilNow(Integer totalDistance) {
        for (int i = 0; i < totalDistance; i++) {
            System.out.print("-");
        }
    }

    public static void printWinnerNames(List<String> winnerNames) {
        System.out.print(String.join(",", winnerNames));
        System.out.println("가 최종 우승했습니다.");
        System.out.println();
    }
}
