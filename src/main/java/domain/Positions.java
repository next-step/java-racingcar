package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Positions {
    private final List<Integer> positions;

    public Positions(List<Position> positions) {
        this.positions = positions.stream()
                .map(Position::getPosition)
                .collect(Collectors.toList());
    }

    public List<Integer> getPositions() {
        return Collections.unmodifiableList(positions);
    }
}
