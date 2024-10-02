package racingcar.basic.controller;

import racingcar.basic.model.Car;
import racingcar.basic.utils.NumberGenerator;
import racingcar.basic.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final List<Car> cars;
    private int numberOfTries;

    public GameController(int numberOfCars, int numberOfTries) {
        this.numberOfTries = numberOfTries;
        cars = createCars(numberOfCars);
    }

    private List<Car> createCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int cnt = 0; cnt < numberOfCars; cnt++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void playGame() {
        ResultView.showResultDescription();
        for (int round = 1; round <= numberOfTries; round++) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            moveCar(car);
        }
        showPlayResult();
    }

    private void moveCar(Car car) {
        car.moveForward(NumberGenerator.randomNumber());
    }

    private void showPlayResult() {
        for (Car car : cars) {
            ResultView.showCarStatus(car.getPosition());
        }
        ResultView.nextLine();
    }

    public List<Car> getCars() {
        return cars;
    }
}
