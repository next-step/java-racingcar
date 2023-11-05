package me.namuhuchutong.step3;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> values;

    public static Cars createCars(RacingRule racingRule, int numberOfCars) {
        return Stream.generate(() -> new Car(racingRule, 0))
                     .limit(numberOfCars)
                     .collect(collectingAndThen(toUnmodifiableList(), Cars::new));
    }

    private  Cars(List<Car> values) {
        validateNumberOfCars(values.size());
        this.values = values;
    }

    private void validateNumberOfCars(int numberOfCars) {
        if (numberOfCars <= 0) {
            throw new IllegalArgumentException("자동차 수는 음수이거나 0일 수 없습니다. - " + numberOfCars);
        }
    }

    public Cars raceAllCars() {
        this.values.forEach(Car::move);
        return new Cars(copyOf(values));
    }

    private List<Car> copyOf(List<Car> values) {
        return values.stream()
                      .map(Car::from)
                      .collect(toUnmodifiableList());
    }

    public List<Car> getCars() {
        return this.values;
    }
}
