package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(int count) {
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
