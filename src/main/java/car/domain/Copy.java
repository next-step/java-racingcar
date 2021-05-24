package car.domain;

import java.util.ArrayList;
import java.util.List;

public class Copy {
    private List<Car> cars;

    public Copy(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> createCopiedCars() {
        List<Car> copiedCars = new ArrayList<>();

        for (Car car : cars) {
            Car copiedCar = new Car(car.getName(), car.getKm());
            copiedCars.add(copiedCar);
        }

        return copiedCars;
    }
}
