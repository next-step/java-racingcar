package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarPositions {
    private final List<CarPosition> positions;

    public CarPositions(List<CarPosition> positions) {
        this.positions = positions;
    }

    public List<CarPosition> getPositions() {
        return new ArrayList<>(positions);
    }
}
