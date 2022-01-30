package racinggame.domain.history;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.history.CarHistory;

public class RoundHistory {

    private final List<CarHistory> carHistories;

    public RoundHistory(List<CarHistory> carHistoryList) {
        this.carHistories = carHistoryList;
    }

    public List<CarHistory> getRoundHistory() {
        return new ArrayList<>(carHistories);
    }
}
