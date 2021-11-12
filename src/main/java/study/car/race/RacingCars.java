package study.car.race;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    public RacingCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void race() {
        cars.stream()
            .forEach(car -> car.moveOrStop(RandomUtils.nextInt()));
    }

    public List<Car> result() {
        return cars;
    }
}
