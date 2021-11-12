package study.car.race;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private static final int CRITERIA = 4;

    private final List<Car> cars = new ArrayList<Car>();

    public CarRace(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void race() {
        cars.stream()
            .forEach(car -> decideToMove(car, RandomUtils.nextInt()));
    }

    private void decideToMove(Car car, int moveCondition) {
        if (moveCondition >= CRITERIA) {
            car.move();
        }
    }

    public List<Car> result() {
        return cars;
    }
}
