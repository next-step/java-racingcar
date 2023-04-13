package racingcar;

import java.util.List;

public class LapResult {

    public static final String NAME_POSITION_DELIMITER = " : ";
    private final List<Car> lapResult;

    public LapResult(List<Car> lapResult) {
        this.lapResult = lapResult;
    }

    public String lapResultString() {
        String result = "";
        for (Car car : lapResult) {
            result += carPosition(car);
        }
        result += OutputView.NEW_LINE;
        return result;
    }

    private String carPosition(Car car) {
        return car.name() + NAME_POSITION_DELIMITER + carPositionIndicator(car);
    }

    private String carPositionIndicator(Car car) {
        String result = "";
        for (int p = 0; p < car.position(); p++) {
            result += OutputView.POSITION_INDICATOR;
        }
        result += OutputView.NEW_LINE;
        return result;
    }

}
