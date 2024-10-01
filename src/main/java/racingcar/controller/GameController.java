package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.utils.NumberGenerator.randomNumber;

public class GameController {

    private List<Car> cars;
    private int numberOfCars;
    private int numberOfTries;

    public GameController(int numberOfCars, int numberOfTries) {
        this.numberOfCars = numberOfCars;
        this.numberOfTries = numberOfTries;
        cars = createCars();
    }

    private List<Car> createCars() {
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

    private void showPlayResult() {
        for (Car car : cars) {
            ResultView.showCarStatus(car.getPosition());
        }
        ResultView.nextLine();
    }

    public List<Car> getCars() {
        return cars;
    }

    private void moveCar(Car car) {
        car.moveForward(randomNumber());
    }
}
