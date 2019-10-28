package step2.race.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceHistory {
    List<Integer> history;

    public RaceHistory(List<Integer> positions) {
        this.history = positions;
    }

    public List<Integer> getHistory() {
        return new ArrayList<>(history);
    }
}
