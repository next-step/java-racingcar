package racing;

import java.util.List;

public class CarPositions {
    private final List<Integer> carPositions;

    public CarPositions(List<Integer> carPositions) {
        this.carPositions = carPositions;
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }

    public Integer getCarPosition(int index) {
        return carPositions.get(index);
    }
}
