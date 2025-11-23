package ui;

import model.Car;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private List<Car> cars;

    public CarRacingGame(int carCount) {
        cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(1));
        }
    }


    public void race(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            printCarsStatus();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.tryMoveForward(RandomNumberGenerator.random());
        }
    }

    private void printCarsStatus() {
        for (Car car : cars) {
            printCarPosition(car.getPosition());
        }
        System.out.println();
    }

    private void printCarPosition(int position) {
        System.out.println("-".repeat(position));
    }
}
