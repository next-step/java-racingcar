package racingcar.winner.controller;

import racingcar.winner.domain.Car;
import racingcar.winner.utils.NumberGenerator;
import racingcar.winner.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final List<Car> cars;
    private int numberOfTries;

    public List<Car> getCars() {
        return cars;
    }

    public GameController(String names, int numberOfTries) {
        this.cars = createCars(names);
        this.numberOfTries = numberOfTries;
    }

    private List<Car> createCars(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : StringUtils.split(names)) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void start() {
        for (int round = 1; round < numberOfTries; ++round) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            int randomNumber = NumberGenerator.generateRandomNumber();
            car.moveForward(randomNumber);
        }
    }
}
