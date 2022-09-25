package car;

import java.util.ArrayList;
import java.util.List;

public class RacingCar implements Car {
    private List<Boolean> distance;
    private MovableStrategy movableStrategy;

    public RacingCar(MovableStrategy movableStrategy) {
        distance = new ArrayList<>();
        this.movableStrategy = movableStrategy;
    }

    public boolean isMoveAble(int index) {
        if (index >= distance.size()) {
            return false;
        }
        return distance.get(index);
    }

    public void racing() {
        if (movableStrategy.isMovable()) {
            distance.add(true);
            return;
        }
        distance.add(false);
    }
}
