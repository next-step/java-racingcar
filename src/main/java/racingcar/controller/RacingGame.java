package racingcar.controller;

import racingcar.domain.*;
import racingcar.policy.RandomMovingPolicy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final String CAR_NAME_SEPARATOR = ",";

    private Cars cars;
    private Round round;

    public RacingGame(final String carNames, final Round round) {
        this.cars = ready(carNames);
        this.round = round;
    }

    public void play() {
        moveCars();
        round = round.next();
    }

    public Cars getCars() {
        return cars;
    }

    public boolean isGameOver() {
        return round.isEnd();
    }

    private Cars ready(final String carNames) {
        String[] names = carNames.split(CAR_NAME_SEPARATOR);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(new CarName(name), new Distance()));
        }
        return new Cars(cars);
    }

    private void moveCars() {
        cars.move(new RandomMovingPolicy());
    }
}
