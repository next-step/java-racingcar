package step5.domain;

import step5.domain.strategy.MovingStrategy;
import step5.domain.strategy.RandomMovingStrategy;

import static step5.domain.CarFactory.produceCars;

public class RacingGame {

    Cars cars;
    MovingStrategy strategy;

    public RacingGame(String carNames) {
        cars = new Cars(produceCars(carNames));
        this.strategy = new RandomMovingStrategy(new RandomGenerator());
    }

    public Cars moveCars() {
        cars.moveCars(strategy);
        return cars;
    }

    public Cars getCars() {
        return cars;
    }
}
