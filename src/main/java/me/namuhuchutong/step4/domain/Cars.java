package me.namuhuchutong.step4.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import me.namuhuchutong.step4.domain.rule.RacingRule;

public class Cars {

    private final List<Car> values;

    public static Cars createCars(CarNames carNames) {
        List<Car> collect = carNames.getNames()
                                    .stream()
                                    .map(Car::new)
                                    .collect(toUnmodifiableList());
        return new Cars(collect);
    }

    private Cars(List<Car> values) {
        validateNumberOfCars(values.size());
        this.values = values;
    }

    private void validateNumberOfCars(int numberOfCars) {
        if (numberOfCars <= 0) {
            throw new IllegalArgumentException("자동차 수는 음수이거나 0일 수 없습니다. - " + numberOfCars);
        }
    }

    public Cars raceAllCars(RacingRule racingRule) {
        this.values.forEach(car -> car.move(racingRule));
        return new Cars(copyOf(this.values));
    }

    private List<Car> copyOf(List<Car> values) {
        return values.stream()
                     .map(Car::from)
                     .collect(toUnmodifiableList());
    }

    public List<Car> getValues() {
        return List.copyOf(this.values);
    }
}
