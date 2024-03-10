package racinggame.domain;

import java.util.List;

public class RaceRecord {

    private final List<Position> carsPositions;

    public RaceRecord(List<Position> carsPositions) {
        this.carsPositions = carsPositions;
    }

    public String display() {
        StringBuilder result = new StringBuilder();
        for (Position position : carsPositions) {
            result.append("-".repeat(position.getPosition())).append("\n");
        }
        return result.toString();
    }
}
