package racingcar.winner.model;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final GameAttemptCount gameAttemptCount;

    public RacingGame(final Cars cars, final GameAttemptCount gameAttemptCount) {
        this.cars = cars;
        this.gameAttemptCount = gameAttemptCount;
    }

    public RacingGame play() {
        GameAttemptCount counted = gameAttemptCount.play();
        Cars movedCars = cars.moveCars(new RandomMovableStrategy());

        return new RacingGame(movedCars, counted);
    }

    public boolean isGameEnded() {
        return gameAttemptCount.isEnded();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> findWinner() {
        return cars.findWinner();
    }
}
