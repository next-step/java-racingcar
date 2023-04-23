package racing.domain;

import racing.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public static Cars of(List<String> carNames) {
        return new Cars(convertToCarList(carNames));
    }
    public Cars(List<Car> cars) {
        this.cars = cars;
    }
    public List<Car> getCars() {
        return this.cars;
    }

    private static List<Car> convertToCarList(List<String> carNames) {
        return carNames
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
    public RoundResult race(RacingRule racingRule) {
        List<Car> roundResult = new ArrayList<>();
        for (Car car : cars) {
            roundResult.add(car.race(racingRule.generateNumber()));
        }
        return new RoundResult(roundResult);
    }

    public List<Integer> currentRoundResult() {
        return cars
                .stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
