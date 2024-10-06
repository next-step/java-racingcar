package racingcar.refactoring.controller;

import racingcar.refactoring.domain.Car;
import racingcar.refactoring.domain.GameResult;
import racingcar.refactoring.utils.NumberGenerator;
import racingcar.refactoring.utils.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public GameResult start() {
        List<Map<String, Integer>> gameResults = new ArrayList<>();
        for (int round = 1; round <= numberOfTries; ++round) {
            gameResults.add(playRound());
        }
        return new GameResult(gameResults);
    }

    private Map<String, Integer> playRound() {
        for (Car car : cars) {
            car.moveForward(NumberGenerator.generateRandomNumber());
        }
        return getRoundGameResult();
    }

    private Map<String, Integer> getRoundGameResult() {
        Map<String, Integer> roundResult = new LinkedHashMap<>();
        for (Car car : cars) {
            roundResult.put(car.getName(), car.getPosition());
        }
        return roundResult;
    }
}
