package racingcar.refactoring.controller;

import racingcar.refactoring.domain.Car;
import racingcar.refactoring.domain.Cars;
import racingcar.refactoring.domain.GameResult;
import racingcar.refactoring.utils.NumberGenerator;
import racingcar.refactoring.utils.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameController {

    private final Cars cars;
    private int numberOfTries;

    public GameController(String names, int numberOfTries) {
        this.cars = createCars(names);
        this.numberOfTries = numberOfTries;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    private Cars createCars(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : StringUtils.split(names)) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public GameResult start() {
        List<Map<String, Integer>> gameResults = new ArrayList<>();
        for (int round = 1; round <= numberOfTries; ++round) {
            gameResults.add(playRound());
        }
        return new GameResult(gameResults);
    }

    private Map<String, Integer> playRound() {
        for (Car car : cars.getCars()) {
            car.moveForward(NumberGenerator.generateRandomNumber());
        }
        return getRoundGameResult();
    }

    private Map<String, Integer> getRoundGameResult() {
        Map<String, Integer> roundResult = new LinkedHashMap<>();
        for (Car car : cars.getCars()) {
            roundResult.put(car.getName(), car.getPosition());
        }
        return roundResult;
    }
}
