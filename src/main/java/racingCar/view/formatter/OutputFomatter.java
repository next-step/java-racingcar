package racingCar.view.formatter;

import java.util.List;
import java.util.stream.Collectors;
import racingCar.common.Symbol;
import racingCar.domain.Car;
import racingCar.domain.WinnerGroup;

public class OutputFomatter {

    public static final String MOVEMENT_MARK = Symbol.HYPHEN;
    public static final String WINNERS_SEPARATOR = Symbol.COMMA;

    public String toCarName(Car car) {
        return car.getName();
    }

    public String toMovement(Car car) {
        return MOVEMENT_MARK.repeat(car.getDistance());
    }

    public String toWinners(WinnerGroup winners) {
        List<String> winnerGroup = winners.getWinnerGroup().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        return String.join(WINNERS_SEPARATOR, winnerGroup);
    }
}
