package step3;

import java.util.List;

public class Movement {
    private final List<Car> cars;
    private final RandomMoveStrategy randomMoveStrategy;

    public Movement(List<Car> cars, RandomMoveStrategy randomMoveStrategy) {
        this.cars = cars;
        this.randomMoveStrategy = randomMoveStrategy;
    }

    public void moveCars() {
        for (Car car : cars) {
            if (randomMoveStrategy.canMove()) {
                car.plusTrace();
            }
        }
    }
}
