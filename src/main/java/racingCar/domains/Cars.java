package racingCar.domains;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(String names) {
        this.cars = new ArrayList<>();
        for (String name : names.split(",")) {
            this.cars.add(new Car(name));
        }
    }

    public void move() {
        for (Car car : this.cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
