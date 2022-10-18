package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameRecord;

public class OutputView {

    private static final String SEPARATOR = ", ";

    public static void printResult(final List<GameRecord> result, final List<Car> winners) {
        System.out.println("실행 결과");

        result.forEach(r -> {
            printRacingResult(r);
            System.out.println();
        });

        printWinners(winners);
    }

    private static void printRacingResult(final GameRecord result) {
        result.getRacerResults().forEach(r -> {
            System.out.printf("%s : ", r.getCarName());
            System.out.print("-".repeat(r.getCarPosition()));
            System.out.println();
        });
    }

    private static void printWinners(final List<Car> winners) {
        StringBuilder winnersNames = new StringBuilder();
        winners.forEach(winner ->
            winnersNames.append(winner.getName()).append(SEPARATOR)
        );
        winnersNames.deleteCharAt(winnersNames.lastIndexOf(SEPARATOR.trim()));
        System.out.printf("%s가 최종 우승했습니다.", winnersNames);
    }
}
