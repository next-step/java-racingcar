package racingcar;

import java.util.Random;

public class RacingGame {
    private final int chance;
    private Car[] cars;

    public RacingGame(int carCount, int chance) {
        this.chance = chance;
        initCars(carCount);
    }

    private void initCars(int carCount) {
        this.cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            this.cars[i] = new Car();
        }
    }

    public void racing() {
        for (int i = 0; i < chance; i++) {
            for (Car car : this.cars) {
                car.moveCar(getRandomValue());
                ResultView.printRacingResult(car);
            }
            ResultView.printAsterisk();
        }
    }

    private int getRandomValue() {
        return new Random().nextInt(10);
    }
}
