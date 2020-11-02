package car_racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CarRacingManager {

    private final Random random;
    final List<Car> cars = new ArrayList<>();

    public CarRacingManager(Random random) {
        this.random = random;
    }

    public void setupCars(int numOfCar) {
        cars.clear();
        IntStream.range(0, numOfCar)
                .forEach(i -> cars.add(new Car()));
    }

    public List<Car> forwardEachCar() {
        cars.forEach(car -> car.forwardOrNot(random));
        return cars;
    }
}
