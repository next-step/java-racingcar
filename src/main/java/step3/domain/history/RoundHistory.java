package step3.domain.history;

import java.util.List;

public class RoundHistory {
    private List<CarHistory> roundHistories;

    private RoundHistory() {}

    public RoundHistory(List<CarHistory> carHistoryList) {
        this.roundHistories = carHistoryList;
    }

    public List<CarHistory> getRoundHistories() {
        return roundHistories;
    }
}
