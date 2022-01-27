package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Winners;

public class RacingCarLog {

    private RacingCarLog() {
    }

    public static StringBuilder printCars(StringBuilder gameLog, List<Car> carList) {
        for (Car car : carList) {
            gameLog.append(car);
            gameLog.append("\n");
        }
        gameLog.append("------------------------------\n");
        return gameLog;
    }

    public static StringBuilder printWinner(StringBuilder gameLog, Winners winners) {
        List<String> winnerList = winners.getWinnerCars().stream()
            .map(Car::getName)
            .collect(Collectors.toList());
        gameLog.append(String.join(",", winnerList));
        return gameLog;
    }
}
