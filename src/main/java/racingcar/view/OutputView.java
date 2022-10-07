package racingcar.view;

import java.util.List;
import racingcar.RacingResult;

public class OutputView {

    public static void printResult(List<List<RacingResult>> result, List<String> winners) {
        System.out.println("실행 결과");

        for(List<RacingResult> r : result) {
            printOneGameResult(r);
            System.out.println();
        }

        printWinners(winners);
    }

    private static void printOneGameResult(List<RacingResult> result) {
        for(RacingResult r : result) {
            System.out.printf("%s : ", r.carName());
            System.out.print("-".repeat(r.carPosition()));
            System.out.println();
        }
    }

    private static void printWinners(List<String> winners) {
        System.out.printf("%s 가 최종 우승했습니다.", winners.toString().replaceAll("[\\[\\]]", ""));
    }
}
