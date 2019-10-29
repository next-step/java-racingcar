package step2.race.domain;

import step2.car.domain.Status;

import java.util.Collections;
import java.util.List;

public class RaceHistory {
    private final List<Status> history;

    public RaceHistory(List<Status> statuses) {
        this.history = statuses;
    }

    public List<Status> getHistory() {
        return Collections.unmodifiableList(this.history);
    }
}
