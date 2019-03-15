package racingcar.domain;

import racingcar.rulemanager.RandomNumberLessThanTen;
import racingcar.rulemanager.RuleManager;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int currentTurn;
    private int moveCount;
    private RuleManager ruleManager;

    public RacingGame(String carNames, int moveCount) {
        this.cars = setupCar(carNames);
        this.moveCount = moveCount;
        this.ruleManager = new RandomNumberLessThanTen();
    }

    public RacingGame(String carNames, RuleManager ruleManager) {
        this.cars = setupCar(carNames);
        this.ruleManager = ruleManager;
    }

    public static List<Car> setupCar(String carNames) {
        List<Car> newCars = new ArrayList<>();
        String[] names = carNames.split(",");
        for (String name : names) {
            newCars.add(new Car(name.trim()));
        }
        return newCars;
    }

    public void startRace() {
        for (Car car : cars) {
            car.move(ruleManager.getRandomNum());
        }
        currentTurn++;
    }

    public boolean isEnd() {
        return currentTurn < moveCount;
    }

    public List<Car> getCars() {
        return cars;
    }

}


