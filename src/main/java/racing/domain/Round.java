package racing.domain;

import java.util.HashMap;
import java.util.Map;

public class Round {

    private final int roundNumber;
    private final Map<Car, Integer> carPositions;

    public Round(final int roundNumber, final Map<Car, Integer> carPositions) {
        this.roundNumber = roundNumber;
        this.carPositions = carPositions;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public Map<Car, Integer> getCarPositions() {
        return carPositions;
    }
}
