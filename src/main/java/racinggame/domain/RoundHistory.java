package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundHistory {

    private final List<CarHistory> carHistories;

    public RoundHistory(List<CarHistory> carHistoryList) {
        this.carHistories = carHistoryList;
    }

    public List<CarHistory> getRoundHistory() {
        return new ArrayList<>(carHistories);
    }
}
