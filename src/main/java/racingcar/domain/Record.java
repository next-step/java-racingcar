package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Record {

    private final List<Position> positions;

    public Record(List<Position> positions) {
        this.positions = positions;
    }

    public static Record from(RacingCars racingCars) {
        return new Record(Collections.unmodifiableList(racingCars.getPositions()));
    }

    public List<Position> getPositions() {
        return positions;
    }
}
