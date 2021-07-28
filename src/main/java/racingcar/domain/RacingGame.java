package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;
    private int roundCount;
    private int currentRound = 0;

    public RacingGame(int carCount, int roundCount) {
        checkGreaterThanZero(roundCount);
        this.roundCount = roundCount;
        this.cars = initCars(carCount);
    }

    private void checkGreaterThanZero(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException("라운드 수는 0보다 커야합니다.");
        }
    }

    private Cars initCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }

    public void race(MovableStrategy movableStrategy) {
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
