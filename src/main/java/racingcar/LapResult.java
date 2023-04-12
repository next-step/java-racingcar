package racingcar;

import java.util.List;

public class LapResult {

    private final List<Car> lapResult;

    public LapResult(List<Car> lapResult) {
        this.lapResult = lapResult;
    }

    public String lapResultString() {
        String result = "";
        for (Car car : lapResult) {
            result += carPositionIndicator(car);
        }
        result += OutputView.NEW_LINE;
        return result;
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
