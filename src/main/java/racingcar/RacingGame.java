package racingcar;

import java.util.Arrays;
import java.util.Random;

public class RacingGame {
    private Car[] cars;

    public RacingGame(int numberOfCar) {
        carSetUp(numberOfCar);
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
                    int randomIntUnder10 = new Random().nextInt(10);
                    car.goWhenGreaterThanThreshold(randomIntUnder10);
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
