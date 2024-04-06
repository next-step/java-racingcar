package step3_CarRacing;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    public Race(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }
}
