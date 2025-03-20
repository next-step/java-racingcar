package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarPositions {
    private final List<Integer> positions;

    public CarPositions(List<Integer> positions) {
        this.positions = positions;
    }

    public List<Integer> getPositions() {
        return new ArrayList<>(positions);
    }
}
