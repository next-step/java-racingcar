package model;

import ui.GameUI;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    public void race(int tryCount, List<Car> cars) {
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            GameUI.printCarsStatus(cars);
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.tryMoveForward(RandomNumberGenerator.random());
        }
    }
}
