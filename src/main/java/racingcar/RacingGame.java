package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final int round;
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(int carCount, int round) {
        this.round = round;
        initCars(carCount);
    }

    private void initCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void racing() {
        for (int i = 0; i < round; i++) {
            moveCar();
            printRoundResult();
        }
    }

    private void moveCar() {
        for (Car car : this.cars) {
            car.moveForward(getRandomValue());
        }
    }

    private void printRoundResult() {
        ResultView.printAsterisk();
        for (Car car : this.cars) {
            ResultView.printRacingResult(car);
        }
    }

    private int getRandomValue() {
        return new Random().nextInt(10);
    }
}
