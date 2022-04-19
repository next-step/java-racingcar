package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final List<Car> cars = new ArrayList<>();

    public List<Car> createCar(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
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
