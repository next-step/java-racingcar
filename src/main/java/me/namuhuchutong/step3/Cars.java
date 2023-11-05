package me.namuhuchutong.step3;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Stream;

public class Cars {

    public static final String NEWLINE = "\n";

    private final List<Car> values;

    public static Cars createCars(int numberOfCars) {
        return Stream.generate(Car::new)
                     .limit(numberOfCars)
                     .collect(collectingAndThen(toList(), Cars::new));
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

    public Cars raceAllCars(RacingRule racingRule) {
        this.values.forEach(car -> car.move(racingRule.isSatisfiedRule()));
        return new Cars(copyOf(values));
    }

    private List<Car> copyOf(List<Car> values) {
        return values.stream()
                      .map(Car::from)
                      .collect(toList());
    }

    @Override
    public String toString() {
        StringBuilder carPositions = new StringBuilder();
        buildCarPositions(carPositions);
        return carPositions.toString();
    }

    private void buildCarPositions(StringBuilder carPositions) {
        this.values.forEach(car -> {
            String carPosition = car.getPositionToString();
            carPositions.append(carPosition).append(NEWLINE);
        });
    }
}
