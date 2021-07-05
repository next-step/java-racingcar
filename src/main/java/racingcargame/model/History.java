package racingcargame.model;

import java.util.Map;

public class History {
    private Map<RacingCar, Integer> history;

    public History(Map<RacingCar, Integer> history) {
        this.history = history;
    }

    private Map<RacingCar, Integer> getThisHistory() {
        return history;
    }

    public Map<RacingCar, Integer> getHistory() {
        return new History(history).getThisHistory();
    }
}
