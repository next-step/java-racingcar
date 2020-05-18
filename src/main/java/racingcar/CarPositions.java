package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarPositions {

    private List<CarPosition> positions = new ArrayList<>();

    public void add(CarPosition carPosition) {
        positions.add(carPosition);
    }

    public int size() {
        return positions.size();
    }

    public CarPosition get(int index) {
        return positions.get(index);
    }
}
