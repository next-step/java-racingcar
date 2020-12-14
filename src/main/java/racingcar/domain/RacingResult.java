package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {
    private static final String MOVE_VIEW = "-";
    private static final String NEW_LINE = "\n";
    private static final String NAME_VIEW = " : ";
    private static final String WINNER_SEPARATOR = ",";
    private final StringBuilder racingRounge = new StringBuilder();

    public void reportRacing(List<Car> cars) {
        for (Car car : cars) {
            nameView(car);
            raceView(car);
            racingRounge.append(NEW_LINE);
        }
        racingRounge.append(NEW_LINE);
    }

    private void nameView(Car car) {
        racingRounge.append(car.name());
        racingRounge.append(NAME_VIEW);
    }

    private void raceView(Car car) {
        if (car.isMoved()) {
            moveView(car);
        }
    }

    private void moveView(Car car) {
        for (int i = 0; i < car.position(); i++) {
            racingRounge.append(MOVE_VIEW);
        }
    }

    public StringBuilder racingRounge() {
        return racingRounge;
    }

    private String winner(List<Car> cars) {
        return cars.stream().map(Car::name)
                .collect(Collectors.joining(WINNER_SEPARATOR));
    }

    public void reportWinner(List<Car> cars) {
        racingRounge.append(winner(cars));
    }
}
