package model;

import ui.GameUI;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private List<Car> cars;

    public CarRacingGame(String[] carNames) {
        cars = new ArrayList<>();

        for (String CarName : carNames) {
            cars.add(new Car(1, CarName));
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

    public int getCarsCount() {
        return cars.size();
    }
}
