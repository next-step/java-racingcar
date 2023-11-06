package racingcar.view;

import java.util.List;

public class ResultView {

    public static void printResultStart() {
        System.out.println("\n실행 결과");
    }

    public static void printOneGameResult(List<String> results) {
        for (String result: results) {
            System.out.println(result);
        }

        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        String result = String.join(",", winnerNames) + "가 최종 우승했습니다.";

        System.out.println(result);
    }
}
