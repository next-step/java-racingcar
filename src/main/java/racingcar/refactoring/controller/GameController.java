package racingcar.refactoring.controller;

import racingcar.refactoring.domain.Car;
import racingcar.refactoring.domain.Cars;
import racingcar.refactoring.domain.GameResult;
import racingcar.refactoring.domain.RoundResult;
import racingcar.refactoring.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final Cars cars;

    public GameController(String names) {
        this.cars = createCars(names);
    }

    private Cars createCars(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : StringUtils.split(names)) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public GameResult start(int numberOfTries) {
        List<RoundResult> gameResults = new ArrayList<>();
        for (int round = 1; round <= numberOfTries; ++round) {
            gameResults.add(playRound());
        }
        return new GameResult(gameResults);
    }

    private RoundResult playRound() {
        return new RoundResult(cars.moveAll());
    }
}
