package racinggame;

import java.util.List;

public class Movement {
    private final List<Car> cars;

    public Movement(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            if (moveStrategy.canMove()) {
                car.plusTrace();
            }
        }
    }
}
