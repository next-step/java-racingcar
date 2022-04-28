package model;

import java.util.Map;

public class RoundHistory {
    private Map<CarName, Integer> moveHistories;

    public RoundHistory(Map<CarName, Integer> moveHistories) {
        this.moveHistories = moveHistories;
    }

    public Map<CarName, Integer> getMoveHistory() {
        return moveHistories;
    }
}
