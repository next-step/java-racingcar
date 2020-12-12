package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RacingResult {
    private static final String MOVE_VIEW = "-";
    private static final String STOP_VIEW = "";
    private static final String NEW_LINE = "\n";
    private final StringBuilder racingRounge = new StringBuilder();

    public void report(List<Car> cars) {
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

        if (car.isStop()) {
            stopView();
        }
    }

    private void moveView(Car car) {
        for (int i = 0; i < car.position(); i++) {
            racingRounge.append(MOVE_VIEW);
        }
    }

    private void stopView() {
        racingRounge.append(STOP_VIEW);
    }

    public StringBuilder racingRounge() {
        return racingRounge;
    }
}
