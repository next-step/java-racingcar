package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void play() {
        for (Car car : cars) {
            car.isMove(new RandomMovingStrategy());
        }
    }

}
