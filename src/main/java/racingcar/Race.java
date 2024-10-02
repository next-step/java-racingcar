package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars;

    public Race() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void createCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
    }

    public void round() {
        for (Car car : this.cars) {
            car.run();
        }
    }
}
