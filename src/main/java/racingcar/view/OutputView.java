package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingRecord;

public class OutputView {

    public static void printResult(final List<RacingRecord> result, final List<Car> winners) {
        System.out.println("실행 결과");

        result.forEach(r -> {
            printRacingResult(r);
            System.out.println();
        });

        printWinners(winners);
    }

    private static void printRacingResult(final RacingRecord result) {
        result.getRacerResults().forEach(r -> {
            System.out.printf("%s : ", r.getCarName());
            System.out.print("-".repeat(r.getCarPosition()));
            System.out.println();
        });
    }

    private static void printWinners(final List<Car> winners) {
        StringBuilder winnersNames = new StringBuilder();
        winners.forEach(winner ->
            winnersNames.append(winner.getName()).append(", ")
        );
        winnersNames.deleteCharAt(winnersNames.lastIndexOf(","));
        System.out.printf("%s가 최종 우승했습니다.", winnersNames);
    }
}
