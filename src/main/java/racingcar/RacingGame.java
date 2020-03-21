package racingcar;

import racingcar.car.Car;
import racingcar.car.MovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {
    private static final int INT_ZERO = 0;

    private int time;
    private List<Car> cars = new ArrayList<>();
    private MovingStrategy movingStrategy;

    public RacingGame(String[] names, MovingStrategy movingStrategy) {
        createCar(names);
        this.movingStrategy = movingStrategy;
    }

    private void createCar(String[] names) {
        if (Objects.isNull(names) || names.length <= INT_ZERO) {
            throw new IllegalArgumentException("자동차의 개수는 1보다 커야 합니다.");
        }
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public RacingScore execute() {
        List<Car> executedCars = new ArrayList<>();
        for (Car car : cars) {
            car.move(movingStrategy);
            executedCars.add(car.clone());
        }
        time++;

        return new RacingScore(executedCars);
    }

    public int getTime() {
        return time;
    }
}
