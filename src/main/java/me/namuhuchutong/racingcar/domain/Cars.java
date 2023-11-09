package me.namuhuchutong.racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import me.namuhuchutong.racingcar.domain.rule.RacingRule;

public class Cars {

    private final List<Car> values;

    public static Cars createCars(CarNames carNames) {
        List<Car> collect = carNames.getNames()
                                    .stream()
                                    .map(Car::new)
                                    .collect(toUnmodifiableList());
        return new Cars(collect);
    }

    public Cars(List<Car> values) {
        validateNumberOfCars(values.size());
        this.values = values;
    }

    private void validateNumberOfCars(int numberOfCars) {
        if (numberOfCars <= 0) {
            throw new IllegalArgumentException("자동차 수는 음수이거나 0일 수 없습니다. - " + numberOfCars);
        }
    }

    public Cars raceAllCars(RacingRule racingRule) {
        List<Car> collect = this.values.stream()
                                       .map(car -> car.move(racingRule))
                                       .collect(toUnmodifiableList());
        return new Cars(collect);
    }

    public List<Car> getValues() {
        return List.copyOf(this.values);
    }
}
