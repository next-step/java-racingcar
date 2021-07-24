package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public List<Car> cars = new ArrayList<>();

    private void addCar(Car car) {
        cars.add(car);
    }

    public void addCars(int countOfCar) {
        for (int i = 0; i < countOfCar; i++) {
            addCar(new Car());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
