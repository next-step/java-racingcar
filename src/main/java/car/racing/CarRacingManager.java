package car.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CarRacingManager {

    final List<Car> cars = new ArrayList<>();

    public void setupCars(int numOfCar) {
        cars.clear();
        IntStream.range(0, numOfCar)
                .forEach(i -> cars.add(new Car(new ForwardableImpl())));
    }

    public List<Car> forwardEachCar() {
        cars.forEach(Car::forwardOrNot);
        return cars;
    }
}
