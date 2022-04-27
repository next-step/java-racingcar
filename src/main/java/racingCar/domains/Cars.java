package racingCar.domains;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(PositiveNumber number) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < number.getNumber(); i++) {
            this.cars.add(new Car());
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
