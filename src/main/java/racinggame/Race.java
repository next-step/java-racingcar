package racinggame;

import java.util.List;

public class Race {

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Race(final List<Car> cars) {
        this(cars, new RandomMoveStrategy());
    }

    public Race(final List<Car> cars, final MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public List<Car> cars() {
        return this.cars;
    }

    public void run(final int rounds) {
        for (int i = 0; i < rounds; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        cars.forEach(car -> car.move(moveStrategy));
    }
}
