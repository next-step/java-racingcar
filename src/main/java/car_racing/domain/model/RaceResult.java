package car_racing.domain.model;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private static final String CAR_POSITION_MARKER = "-";

    private final List<Integer> positionHistory;

    public RaceResult() {
        this.positionHistory = new ArrayList<>();
    }

    public void addRecord(int distance) {
        positionHistory.add(distance);
    }

    public String getPositionOfNthRound(int n) {
        return CAR_POSITION_MARKER.repeat(positionHistory.get(n));
    }
}
