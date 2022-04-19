package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final List<Car> cars = new ArrayList<>();

    public List<Car> createCar(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public List<Car> startGame(RacingStrategy strategy) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).moveOrStop(strategy, strategy.createNumber());
        }
        return cars;
    }
}
