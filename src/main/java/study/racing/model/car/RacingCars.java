package study.racing.model.car;

import java.util.ArrayList;
import java.util.List;

import study.racing.utils.RandomUtils;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    public RacingCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void race() {
        cars.forEach(car -> car.moveOrStop(RandomUtils.nextInt()));
    }

    public List<Car> result() {
        return cars;
    }
}
