package step2.race.domain;

import java.util.Collections;
import java.util.List;

public class RaceHistory {
    List<Integer> history;

    public RaceHistory(List<Integer> positions) {
        this.history = positions;
    }

    public List<Integer> getHistory() {
        return Collections.unmodifiableList(this.history);
    }
}
