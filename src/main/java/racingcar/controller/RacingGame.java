package racingcar.controller;

import java.util.Random;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingGame {

    private int carCount;
    private int tryCount;
    private static final int RANDOM_MAX_BOUND = 10;
    private Cars cars;

    public RacingGame(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public Cars initRacing() {
        cars = new Cars();
        for (int i = 0; i < carCount; i++) {
            cars.addCar(new Car());
        }
        System.out.println("실행결과");
        return cars;
    }

    private void moveCar(Cars cars) {
        for (Car car : cars.carList()) {
            car.moveForward(new Random().nextInt(RANDOM_MAX_BOUND));
        }
    }

    public boolean isEndGame() {
        return tryCount > 0 ? false : true;
    }

    public void start() {
        moveCar(cars);
        tryCount--;
    }
}
