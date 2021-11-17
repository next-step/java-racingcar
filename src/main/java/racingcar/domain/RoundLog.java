package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RoundLog {
    private final List<Car> carsHistory;

    private RoundLog(List<Car> carsHistory) {
        this.carsHistory = carsHistory;
    }

    public static RoundLog from(List<Car> cars) {
        return new RoundLog(cars);
    }

    public List<Car> getHistory() {
        return Collections.unmodifiableList(carsHistory);
    }
}
