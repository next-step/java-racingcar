package racingcar;

import racingcar.car.Car;
import racingcar.car.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int INT_ZERO = 0;

    private int time;
    private List<Car> cars = new ArrayList<>();
    private MovingStrategy movingStrategy;

    public RacingGame(int numberOfCar, MovingStrategy movingStrategy) {
        createCar(numberOfCar);
        this.movingStrategy = movingStrategy;
    }

    private void createCar(int numberOfCar) {
        if (numberOfCar <= INT_ZERO) {
            throw new IllegalArgumentException("자동차의 개수는 1보다 커야 합니다.");
        }
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> execute() {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
        time++;

        return cars;
    }

    public int getTime() {
        return time;
    }
}
