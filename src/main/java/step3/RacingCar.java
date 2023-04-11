package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private final List<Car> cars = new ArrayList<>();

    public RacingCar(int count) {
        addCars(count);
    }

    public List<Car> getList() {
        return cars;
    }

    private void addCars(int count) {
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
    }
}
