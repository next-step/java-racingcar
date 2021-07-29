package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private Cars cars;
    private int roundCount;
    private int currentRound = 0;
    private MovableStrategy movableStrategy;

    public RacingGame(int carCount, int roundCount, MovableStrategy movableStrategy) {
        checkGreaterThanZero(roundCount);
        this.roundCount = roundCount;
        this.cars = initCars(carCount);
        this.movableStrategy = movableStrategy;
    }

    private void checkGreaterThanZero(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException("라운드 수는 0보다 커야합니다.");
        }
    }

    private Cars initCars(int carCount) {
        List<Car> cars = IntStream.range(0, carCount).
                mapToObj(index -> new Car())
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public void race() {
        for (Car car : cars.getCars()) {
            car.move(movableStrategy);
        }
        currentRound++;
    }

    public Cars getCars() {
        return cars;
    }

    public boolean isEnd() {
        return currentRound >= roundCount;
    }
}
