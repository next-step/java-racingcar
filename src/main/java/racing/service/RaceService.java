package racing.service;

import java.util.List;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.MovingStrategy;
import racing.domain.RandomMovingStrategy;

public class RaceService {
    private static final int RAND = 10;

    private final MovingStrategy movingStrategy;
    private Cars cars;
    private final int moveCount;
    private int round = 0;

    public RaceService(List<String> carNames, int moveCount) {
        this(carNames, moveCount, new RandomMovingStrategy(RAND));
    }

    public RaceService(List<String> carNames, int moveCount, MovingStrategy movingStrategy) {
        this.cars = Cars.create(carNames);
        this.moveCount = moveCount;
        this.movingStrategy = movingStrategy;
    }

    public void race() {
        this.cars = cars.move(movingStrategy);
        round++;
    }

    public Cars getCars() {
        return this.cars;
    }

    public boolean gameEnd() {
        return this.moveCount == round;
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }
}
