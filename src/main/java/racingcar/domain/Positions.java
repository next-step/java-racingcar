package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Positions {
    private final List<Position> positions;

    public Positions() {
        this.positions = new ArrayList<>();
    }

    public void save(Position position) {
        positions.add(position);
    }

    public List<Position> getPositions() {
        return positions;
    }

}
