package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int number) {
        this.cars = new ArrayList<>();
        addCar(number);
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
