package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingCarLog {

    private RacingCarLog() {
    }

    public static StringBuilder printWinner(StringBuilder gameLog, Cars cars) {
        List<String> winnerList = cars.getWinners().stream()
            .map(Car::getName)
            .collect(Collectors.toList());
        return gameLog.append(String.join(",",winnerList));
    }
}
