package racing.domain;

import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private final List<Car> cars = new ArrayList<>();

    public int getNumberOfCars() {
        return this.cars.size();
    }

    public List<Car> createCars(int number) {
        for (int i = 0; i < number; i++) {
            Car car = new Car();
            cars.add(car);
        }

        return this.cars;
    }

}
