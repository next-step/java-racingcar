package step5.domain;

import step5.domain.car.Car;
import step5.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingHistory {

    private final List<Cars> history ;

    public RacingHistory() {
        this.history = new ArrayList<>();
    }

    public static RacingHistory defaultOf() {
        return new RacingHistory();
    }

    public void addHistory(Cars cars) {
        history.add(cars);
    }

    @Override
    public String toString() {
        StringBuilder allHistory = new StringBuilder();
        for (Cars history : this.history) {
            allHistory.append(history.statusToString());
        }
        return allHistory.toString();
    }
}
