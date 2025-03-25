package step5.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final MovingStrategy movingStrategy;

    public RacingGame(Cars cars, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public List<CarStatusDto> playRound() {
        cars.moveAll(movingStrategy);
        return cars.getCurrentStatus();
    }

    public List<CarStatusDto> winners() {
        return cars.findWinnersStatus();
    }
}
