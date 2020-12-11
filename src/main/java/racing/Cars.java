package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

public class Cars {

    private List<Car> cars = new ArrayList<>();
    private final MoveStrategy strategy;

    public Cars(int count, MoveStrategy strategy) {
        this.strategy = strategy;
        for (int j = 0; j < count; j++) {
            cars.add(new Car());
        }
    }

    public int size() {
        return cars.size();
    }

    public void moveAll() {
        for (Car car : cars) {
            tryMove(car);
        }
    }

    public void iterateCar(IntConsumer distanceConsumer) {
        for (Car car : cars) {
            distanceConsumer.accept(car.getMovedDistance());
        }
    }

    private void tryMove(Car car) {
        if (strategy.movable()) {
            car.move();
        }
    }
}
