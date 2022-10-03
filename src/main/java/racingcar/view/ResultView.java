package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.CarStat;
import racingcar.domain.Name;
import racingcar.domain.Position;
import racingcar.domain.RoundResult;

public class ResultView {

    private static final String RESULT_DESCRIPTION = "실행 결과";
    private static final String WINNER_DESCRIPTION = "가 최종 우승했습니다.";
    private static final String PATH_STRING = "-";

    public void printTitle() {
        System.out.println("\n" + RESULT_DESCRIPTION);
    }

    public void printResult(RoundResult roundResult) {
        for (var car : roundResult.getCarStats()) {
            System.out.println(makeFormattedString(car.getName(), car.getPosition()));
        }
        printNewLine();
    }

    public void printWinners(List<CarStat> winners) {
        System.out.printf("%s%s%n", formatWinnerNames(winners), WINNER_DESCRIPTION);
    }

    private String formatWinnerNames(List<CarStat> winners) {
        return winners.stream()
            .map(CarStat::getName)
            .map(Name::getValue)
            .collect(Collectors.joining(", "));
    }

    private String makeFormattedString(Name name, Position position) {
        return String.format("%s : %s", name.getValue(), PATH_STRING.repeat(position.getValue()));
    }

    private void printNewLine() {
        System.out.println();
    }
}
