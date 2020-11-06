package car.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRacingManager {

    private final Forwardable forwardable = new ForwardableImpl();
    final List<Car> cars = new ArrayList<>();

    public void setupCars(int numOfCar) {
        List<Car> cars = Stream.generate(() -> new Car(forwardable))
                .limit(numOfCar)
                .collect(Collectors.toList());
        this.cars.clear();
        this.cars.addAll(cars);
    }

    public List<Car> forwardEachCar() {
        cars.forEach(Car::forwardOrNot);
        return cars;
    }
}
