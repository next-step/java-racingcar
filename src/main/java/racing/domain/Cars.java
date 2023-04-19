package racing.domain;

import racing.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;
    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void race(RacingRule racingRule) {
        List<Integer> result = new ArrayList<>();
        for (Car car : carList) {
            car.race(racingRule.generateNumber());
        }
    }

    public int countTotalCar() {
        return carList.size();
    }

    public List<String> valueOfEntryNameList() {
        List<String> entryNameList = new ArrayList<>();
        for (Car car : carList) {
            entryNameList.add(car.valueOfName());
        }
        return entryNameList;
    }

    public List<Integer> currentRoundResult() {
        List<Integer> currentPositions = new ArrayList<>();
        for (Car car : carList) {
            currentPositions.add(car.valueOfCurrentPosition());
        }
        return currentPositions;
    }
}
