package step3.domain.history;

import java.util.Comparator;
import java.util.List;

public class RoundHistory {
    private List<CarHistory> carHistories;

    private RoundHistory() {}

    public RoundHistory(List<CarHistory> carHistoryList) {
        this.carHistories = carHistoryList;
    }

    public List<CarHistory> getCarHistories() {
        return carHistories;
    }

    public int getMaxPosition() {
        return carHistories.stream()
                .max(Comparator.comparingInt(CarHistory::getPosition))
                .map(CarHistory::getPosition)
                .orElse(0);
    }
}
