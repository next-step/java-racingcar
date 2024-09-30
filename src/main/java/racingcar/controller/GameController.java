package racingcar.controller;

import racingcar.model.Car;
import racingcar.utils.NumberGenerator;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public static final int RANDOM_THRESHOLD = 4;

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
        ResultView.nextLine();
    }

    private void moveCar(Car car) {
        int randomNumber = NumberGenerator.randomNumber();
        if (randomNumber >= RANDOM_THRESHOLD) {
            car.move();
        }
        ResultView.showCarStatus(car);
    }
}
