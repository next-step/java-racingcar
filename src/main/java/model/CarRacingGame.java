package model;

import ui.GameUI;
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
            GameUI.printCarsStatus(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.tryMoveForward(RandomNumberGenerator.random());
        }
    }
}
