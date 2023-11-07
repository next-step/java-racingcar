package racingcar.core;

import racingcar.domain.Car;

import java.util.List;

public class RacingCar {
    private static final int DEFAULT_FORWARD_CNT = 0;
    private static final int CONDITION_NUMBER = 4;
    private int raceTimes;
    private List<Car> cars;

    public RacingCar(int raceTimes, List<Car> cars) {
        this.raceTimes = raceTimes;
        this.cars = cars;
    }

    public void start() {

        for (int i = 0; i < raceTimes; i++) {
            goRace(raceTimes, cars);
        }
    }

    private void goRace(int raceTimes, List<Car> cars) {
        moveCar(cars);
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward();
        }
    }
}
