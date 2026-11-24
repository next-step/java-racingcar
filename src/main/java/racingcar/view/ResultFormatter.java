package racingcar.view;

import racingcar.domain.CarName;
import racingcar.domain.CarResult;
import racingcar.domain.RoundResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultFormatter {
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String POSITION_MARK = "-";
    private static final String WINNER_DELIMITER = ", ";
    private static final String WINNER_SUFFIX = "가 최종 우승했습니다.";

    private ResultFormatter() {
    }

    public static String formatCar(CarResult carResult) {
        return carResult.name().value() + NAME_POSITION_DELIMITER + POSITION_MARK.repeat(carResult.position());
    }

    public static String formatRound(RoundResult roundResult) {
        return roundResult.carResults().stream()
                .map(ResultFormatter::formatCar)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public static String formatWinners(List<CarName> winners) {
        return winners.stream()
                .map(CarName::value)
                .collect(Collectors.joining(WINNER_DELIMITER)) + WINNER_SUFFIX;
    }
}
