package car.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CarRacingManager {

    private final Forwardable forwardable = new ForwardableImpl();
    final List<Car> cars = new ArrayList<>();

    public void setupCars(int numOfCar) {
        cars.clear();
        IntStream.range(0, numOfCar)
                .forEach(i -> cars.add(new Car(forwardable)));
    }

    public List<Car> forwardEachCar() {
        cars.forEach(Car::forwardOrNot);
        return cars;
    }
}
