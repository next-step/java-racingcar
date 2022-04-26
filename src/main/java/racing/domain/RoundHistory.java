package racing.domain;

import java.util.Map;

public class RoundHistory {
    private final Map<String, Position> carPositions;

    public RoundHistory(Map<String, Position> carPositions) {
        this.carPositions = carPositions;
    }

    public Map<String, Position> getCarPositions() {
        return carPositions;
    }
}
