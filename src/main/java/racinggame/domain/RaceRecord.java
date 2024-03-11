package racinggame.domain;

import java.util.List;

public class RaceRecord {

    private final List<Position> carsPositions;

    public RaceRecord(List<Position> carsPositions) {
        this.carsPositions = carsPositions;
    }

    public List<Position> getCarsPositions() {
        return carsPositions;
    }
}
