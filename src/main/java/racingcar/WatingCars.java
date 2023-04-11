package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WatingCars {

    List<Car> cars = new ArrayList<>();

    public WatingCars(int count) {
        valid(count);
        waiting(count);
    }

    private void valid(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("자동차는 1개 이상이여야 합니다.");
        }
    }

    private void waiting(int count) {
        for (int i = 0; i < count; i++) {
            cars.add(new Car(new RandomNumberGenerator()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
