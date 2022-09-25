package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int carCount) {
        cars = createCars(carCount);
    }

    private List<Car> createCars(int carCount) {
        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public List<Position> move(MovingStrategy movingStrategy) {
        List<Position> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.move(movingStrategy));
        }
        return positions;
    }
}
