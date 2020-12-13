package racingcar.domain;

import java.util.List;

public class RacingResult {
    private static final String MOVE_VIEW = "-";
    private static final String DEFAULT_VIEW = "";
    private static final String NEW_LINE = "\n";
    private final StringBuilder racingRounge = new StringBuilder();

    public void report(List<Car> cars) {
        racingRounge.append(DEFAULT_VIEW);
        for (Car car : cars) {
            raceView(car);
            racingRounge.append(NEW_LINE);
        }
        racingRounge.append(NEW_LINE);
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
}
