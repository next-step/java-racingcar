package racingcar.controller;

import racingcar.domain.Car;
import racingcar.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int carCount;
    private int tryCount;
    private List<Car> cars;

    public RacingGame(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public void startRacing() {
        cars = new ArrayList<>();
        for (int i = 0; i <= carCount; i++) {
            cars.add(new Car(0, RandomNumber.getNumber()));
        }
        moveCar(cars);
        tryCount--;
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward();
        }
    }

    public boolean isEndGame() {
        return tryCount == 0 ? true : false;
    }

    public List<Car> getCars() {
        return cars;
    }
}
