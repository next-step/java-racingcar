package step5.racing.controller;

import step5.racing.domain.CarNames;
import step5.racing.domain.Cars;
import step5.racing.domain.MoveStrategy;
import step5.racing.domain.RandomMoveStrategy;
import step5.racing.domain.RandomNumberGenerator;
import step5.racing.domain.TryCount;

public class Game {

    private final Cars cars;
    private TryCount tryCount;

    public Game(CarNames carNames, TryCount tryCount) {
        this.cars = new Cars(carNames);
        this.tryCount = tryCount;
    }

    public void race() {
        MoveStrategy moveStrategy = createMoveStrategy();

        while (!tryCount.isEnd()) {
            tryCount = tryCount.decrease();
            cars.move(moveStrategy);
        }
    }

    private MoveStrategy createMoveStrategy() {
        return new RandomMoveStrategy(new RandomNumberGenerator());
    }
}
