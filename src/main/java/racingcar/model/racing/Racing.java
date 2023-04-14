package racingcar.model.racing;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.strategy.RandomMovingStrategy;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Racing {
    private final Cars cars;
    private final Round round;

    public Racing(int totalRound, List<Car> cars) {
        this.round = new Round(totalRound);
        this.cars = new Cars(cars);
    }

    public static Racing init(int totalRound, List<String> names) {
        List<Car> cars = names.stream()
                .map((name) -> new Car(name, new RandomMovingStrategy()))
                .collect(toList());

        return new Racing(totalRound, cars);
    }

    public Cars cars() {
        return this.cars;
    }

    public void step() {
        if (isOver()) {
            throw new IllegalStateException("race is over");
        }
        cars.move();
        round.next();
    }

    public int currentRound() {
        return this.round.current();
    }

    public boolean isOver() {
        return this.round.isOver();
    }

    public List<Car> winners() {
        if (!isOver()) {
            throw new IllegalStateException("race is not over");
        }
        return cars.leaders();
    }

}
