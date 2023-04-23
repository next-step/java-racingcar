package racing.domain;

import racing.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void race(RacingRule racingRule) {
        List<Integer> result = new ArrayList<>();
        for (Car car : cars) {
            car.race(racingRule.generateNumber());
        }
    }

    public int countTotalCar() {
        return cars.size();
    }

    public List<String> valueOfEntryNameList() {
        List<String> entryNames = new ArrayList<>();
        for (Car car : cars) {
            entryNames.add(car.valueOfName());
        }
        return entryNames;
    }

    public List<Integer> currentRoundResult() {
        List<Integer> currentPositions = new ArrayList<>();
        for (Car car : cars) {
            currentPositions.add(car.valueOfCurrentPosition());
        }
        return currentPositions;
    }
}
