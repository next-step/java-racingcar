package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        this.cars = cars;
    }

    public boolean isCarCount(int carCount) {
        return this.cars.size() == carCount;
    }
}
