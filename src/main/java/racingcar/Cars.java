package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int number) {
        this.cars = new ArrayList<>();
        addCar(number);
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public String distanceDriven() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.distanceDriven());
            result.append("\n");
        }
        return result.toString();
    }

    public int size() {
        return cars.size();
    }

    private void addCar(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }
}
