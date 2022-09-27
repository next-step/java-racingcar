package racingcar;

import racingcar.strategy.MovingStrategy;

import java.util.List;

public class RacingCarGame {

    private final Cars cars;
    private int playCount;

    public RacingCarGame(int carCount, int playCount) {
        this.cars = new Cars(carCount);
        this.playCount = playCount;
    }

    public List<Car> play(MovingStrategy movingStrategy) {
        playCount--;
        return cars.move(movingStrategy);
    }

    public boolean isEnd() {
        return playCount <= 0;
    }
}
