package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    private static final List<Car> cars = new ArrayList<>();
    private static final List<String> winners = new ArrayList<>();

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

    public List<String> calMaxWinner() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            list.add(cars.get(i).getMovement());
        }
        Integer max = Collections.max(list);

        for (Car car : cars) {
            if (max == car.getMovement()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

}
