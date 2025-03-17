package car_racing.domain.model;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private final List<Integer> positionHistory;

    public RaceResult() {
        this.positionHistory = new ArrayList<>();
    }

    public void addRecord(int distance) {
        positionHistory.add(distance);
    }

    public Integer getPositionOfNthRound(int n) {
        return positionHistory.get(n);
    }
}
