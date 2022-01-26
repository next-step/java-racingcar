package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

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

    public static StringBuilder printWinner(StringBuilder gameLog, List<Car> carWinnerList) {
        List<String> winnerList = carWinnerList.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
        gameLog.append(String.join(",", winnerList));
        return gameLog;
    }
}
