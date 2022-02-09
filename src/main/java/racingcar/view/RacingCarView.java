package racingcar.view;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingCarView {

    private RacingCarView() {
    }

    public static StringBuilder printWinner(StringBuilder gameLog, Cars cars) {
        String winners = cars.getWinners().stream()
            .map(Car::getName)
            .collect(Collectors.joining(","));
        return gameLog.append(winners);
    }
}
