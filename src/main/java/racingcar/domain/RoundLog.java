package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RoundLog {
    private final List<Car> carsHistory;

    private RoundLog(List<Car> carsHistory) {
        validateCarsHistory(carsHistory);
        this.carsHistory = carsHistory;
    }

    private void validateCarsHistory(List<Car> carsHistory) {
        if (carsHistory.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static RoundLog from(List<Car> cars) {
        return new RoundLog(cars);
    }

    public List<Car> getHistory() {
        return Collections.unmodifiableList(carsHistory);
    }
}
