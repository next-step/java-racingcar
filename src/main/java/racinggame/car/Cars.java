package racinggame.car;

import racinggame.util.RandomNumber;
import racinggame.util.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int count) {
        if (!Validator.isPositiveNumber(count)) {
            throw new IllegalArgumentException("시도할 회수는 0보다 큰 숫자여야 합니다.");
        }
        this.cars = initCars(count);
    }

    private List<Car> initCars(int count) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Car());
        }

        return list;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void race(RandomNumber randomNumber) {
        for (Car car : cars) {
            car.race(randomNumber.createBetweenZeroToNine());
        }
    }
}
