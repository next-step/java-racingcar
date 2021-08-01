package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private final List<Car> cars;

    public CarRacing(int carCount) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> racing() {
        for (Car car : cars) {
            car.moveForward(CarUtils.getNumberForMovement());
        }
        return cars;
    }
}
