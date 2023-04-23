package racing.domain;

import racing.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return cars
                .stream()
                .map(Car::valueOfName)
                .collect(Collectors.toList());
    }

    public List<Integer> currentRoundResult() {
        return cars
                .stream()
                .map(Car::valueOfCurrentPosition)
                .collect(Collectors.toList());
    }
}
