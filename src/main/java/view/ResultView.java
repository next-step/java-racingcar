package view;

import java.util.List;

public class ResultView {
    private static final String RESULT_START_MESSAGE = "실행 결과";

    public static void printRaceStartMessage() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public static void printStatus(List<String> result) {
        for (String carStatus : result) {
            System.out.println(carStatus);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.printf("%s(이)가 최종 우승했습니다.", String.join(", ", winnerNames));    }
}
