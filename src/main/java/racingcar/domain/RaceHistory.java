package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Cars getFinishedCars() {
        return history.get(history.size() - 1);
    }

    public RaceHistory update(Cars cars) {
        history.add(cars);
        return new RaceHistory(history);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RaceHistory)) {
            return false;
        }
        RaceHistory that = (RaceHistory) o;
        return Objects.equals(getHistory(), that.getHistory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHistory());
    }
}
