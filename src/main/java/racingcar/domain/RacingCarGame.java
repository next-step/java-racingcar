package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.List;

public class RacingCarGame {

    private final Cars cars;
    private int playCount;

    public RacingCarGame(String[] carNames, int playCount) {
        this.cars = new Cars(carNames);
        this.playCount = playCount;
    }

    public List<Car> findWinners() {
        return cars.findMaxPositionCars();
    }

    public List<Car> play(MovingStrategy movingStrategy) {
        playCount--;
        return cars.move(movingStrategy);
    }

    public boolean isEnd() {
        return playCount <= 0;
    }
}
