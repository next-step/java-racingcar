package racingcar.domain;

import java.util.List;

public class GameBoard {

    private final Cars cars;
    private TryCount tryCount;
    private final MovingStrategy movingStrategy;

    GameBoard(List<Car> cars, TryCount tryCount, MovingStrategy movingStrategy) {
        this(new Cars(cars), tryCount, movingStrategy);
    }

    public GameBoard(Cars cars, TryCount tryCount, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.movingStrategy = movingStrategy;
    }

    public void play() {
        cars.move(movingStrategy);
        decreaseTryCount();
    }

    private void decreaseTryCount() {
        this.tryCount = tryCount.decrease();
    }

    public CarNames getWinnerNames() {
        return cars.getWinnerNames();
    }

    public Cars getCars() {
        return this.cars;
    }

    public boolean isFinish() {
        return this.tryCount.isZero();
    }
}
