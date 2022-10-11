package racingcar.view;

import java.util.List;
import racingcar.output.RacingResult;

public class OutputView {

    public static void printResult(final List<RacingResult> result, final List<String> winners) {
        System.out.println("실행 결과");

        result.forEach(r -> {
            printRacingResult(r);
            System.out.println();
        });

        printWinners(winners);
    }

    private static void printRacingResult(final RacingResult result) {
        result.getRacerResults().forEach(r -> {
            System.out.printf("%s : ", r.getCarName());
            System.out.print("-".repeat(r.getCarPosition()));
            System.out.println();
        });
    }

    private static void printWinners(final List<String> winners) {
        System.out.printf("%s 가 최종 우승했습니다.", winners.toString().replaceAll("[\\[\\]]", ""));
    }
}
