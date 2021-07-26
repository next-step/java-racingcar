package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceHistory {

    private final List<Cars> history;

    public RaceHistory() {
        history = new ArrayList<>();
    }

    public RaceHistory(List<Cars> history) {
        this.history = history;
    }

    public List<Cars> getHistory() {
        return history;
    }

    public RaceHistory update(Cars cars) {
        history.add(cars);
        return new RaceHistory(history);
    }
}
