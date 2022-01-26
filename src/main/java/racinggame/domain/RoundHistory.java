package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundHistory {

    private final List<CarHistory> carHistoryList;

    public RoundHistory(List<CarHistory> carHistoryList) {
        this.carHistoryList = carHistoryList;
    }

    public List<CarHistory>getRoundHistory(){
        return new ArrayList<>(carHistoryList);
    }
}
