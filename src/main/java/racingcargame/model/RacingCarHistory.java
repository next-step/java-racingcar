package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarHistory {
    private List<String> history;

    public RacingCarHistory(List<String> history) {
        this.history = history;
    }

    private List<String> getThisHistory() {
        return history;
    }

    public List<String> getHistory() {
        return new RacingCarHistory(history).getThisHistory();
    }
}
