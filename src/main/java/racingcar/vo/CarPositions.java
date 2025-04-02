package racingcar.vo;

import java.util.*;

public class CarPositions {

    private final List<CarPosition> values;

    public CarPositions(List<CarPosition> values) {
        this.values = new ArrayList<>(values);
    }

    public CarPosition getMaxPosition() {
        return this.values.stream()
            .max(Comparator.comparingInt(CarPosition::getValue))
            .orElse(CarPosition.initialize());
    }
}

