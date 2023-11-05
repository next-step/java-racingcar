package racingcar.model;

import java.util.Arrays;

public class RacingGame {

    private final Car[] cars;

    public RacingGame(int numberOfCars) {
        this.cars = new Car[numberOfCars];
        Arrays.setAll(cars, i -> new Car());
    }

    public void startGame(int count) {
        System.out.println("실행 결과");
        printOnce();
        System.out.println();
        for (int i = 0; i < count; i++) {
            moveOnce();
            printOnce();
            System.out.println();
        }
    }

    private void moveOnce() {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    private void printOnce() {
        for (Car car : cars) {
            car.printPosition();
        }
    }
}