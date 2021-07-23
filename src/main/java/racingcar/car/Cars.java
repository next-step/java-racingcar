package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public List<Car> cars = new ArrayList<>();

    public void setCars(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            addCar(new Car());
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
