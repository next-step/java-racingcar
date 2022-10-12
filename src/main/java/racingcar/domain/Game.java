package racingcar.domain;

import racingcar.listener.GameEventListener;

import java.util.List;

public class Game {
    private final GameEventListener eventListener;
    private final int repeat;
    private final List<Car> cars;

    public Game(String[] names, int repeat, GameEventListener eventListener) {
        this.repeat = repeat;
        this.cars = CarUtil.initCars(names);
        this.eventListener = eventListener;
    }

    public void start() {
        eventListener.onStart();
        for (int i = 0; i < repeat; i++) {
            round();
            eventListener.afterRound(cars);
        }

        eventListener.afterGame(cars);
    }

    private void round() {
        cars.forEach(Car::go);
    }

    public List<Car> getCars() {
        return cars;
    }
}
