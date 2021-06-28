package racingcargame.model;

import java.util.Map;

public class History {
    private Map<String, Integer> history;

    public History(Map<String, Integer> history) {
        this.history = history;
    }

    private Map<String, Integer> getThisHistory() {
        return history;
    }

    public Map<String, Integer> getHistory() {
        return new History(history).getThisHistory();
    }
}
