package game.domain;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private List<Car> cars;

    private CarList(List<Car> cars) {
        this.cars = cars;
    }

    public static CarList makeCars(int number) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
        return new CarList(cars);
    }

    public List<Car> cars() {
        return cars;
    }
}
