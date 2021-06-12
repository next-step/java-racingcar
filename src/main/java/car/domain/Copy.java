package car.domain;

import java.util.ArrayList;
import java.util.List;

public class Copy {
    private Cars cars;

    public Copy(Cars cars) {
        this.cars = cars;
    }

    public List<Car> createCopiedCars() {
        List<Car> copiedCars = new ArrayList<>();

        for (Car car : cars.getCars()) {
            Car copiedCar = new Car(car.getName(), car.getKm());
            copiedCars.add(copiedCar);
        }

        return copiedCars;
    }
}
