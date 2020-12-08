package step4.domain;

import step4.domain.strategy.MovingStrategy;
import step4.domain.strategy.RandomMovingStrategy;

import static step4.domain.CarFactory.produceCars;

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
