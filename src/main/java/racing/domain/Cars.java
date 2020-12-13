package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

import static racing.common.Verify.checkArgument;

public class Cars {

    private static final String CAR_COUNT_ERROR_MESSAGE = "The number of cars must be at least 1";

    private final List<Car> cars = new ArrayList<>();

    public Cars(int count) {
        checkArgument(count > 0, CAR_COUNT_ERROR_MESSAGE);

        for (int j = 0; j < count; j++) {
            cars.add(new Car());
        }
    }

    public int size() {
        return cars.size();
    }

    public void moveAll(MoveStrategy strategy) {
        for (Car car : cars) {
            tryMove(car, strategy);
        }
    }

    public void iterateCar(IntConsumer distanceConsumer) {
        for (Car car : cars) {
            distanceConsumer.accept(car.getMovedDistance());
        }
    }

    private void tryMove(Car car, MoveStrategy strategy) {
        if (strategy.movable()) {
            car.move();
        }
    }
}
