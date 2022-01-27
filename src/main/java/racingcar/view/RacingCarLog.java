package racingcar.view;

import java.util.List;
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
        return gameLog.append(winners);
    }
}
