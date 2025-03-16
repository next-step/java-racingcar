package game;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(PositiveInteger count) {
        this.cars = createCars(count.value());
    }

    private List<Car> createCars(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void race(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : this.cars) {
            car.move(randomNumberGenerator.generate());
        }
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : this.cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }
}
