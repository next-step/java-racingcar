package racingcar;

import racingcar.random.PositiveIntUnder10Generator;
import racingcar.random.RandomIntGenerator;

import java.util.Arrays;

public class RacingGame {
    private Car[] cars;
    private RandomIntGenerator randomIntGenerator;

    public RacingGame(int numberOfCar) {
        this(numberOfCar, new PositiveIntUnder10Generator());
    }

    public RacingGame(int numberOfCar, RandomIntGenerator randomIntGenerator) {
        carSetUp(numberOfCar);
        this.randomIntGenerator = randomIntGenerator;
    }

    private void carSetUp(int numberOfCar) {
        this.cars = new Car[numberOfCar];

        for (int i = 0; i < numberOfCar; i++)
            this.cars[i] = new Car();
    }

    public void start(int tryCount) {
        System.out.println("실행 결과\n");

        for (int i = 0; i < tryCount; i++) {
            runCars();
            showMovedDistanceOfCars();
            System.out.println();
        }
    }

    private void runCars() {
        Arrays.stream(this.cars)
                .forEach(car -> {
                    int randomInt = this.randomIntGenerator.getRandomInt();
                    car.goWhenGreaterThanThreshold(randomInt);
                });
    }

    private void showMovedDistanceOfCars() {
        Arrays.stream(this.cars)
                .forEach(Car::showMovedDistance);
    }

    public Car[] getCars() {
        return this.cars;
    }
}
