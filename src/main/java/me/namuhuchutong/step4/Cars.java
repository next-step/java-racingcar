package me.namuhuchutong.step4;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> values;

    public static Cars createCars(int numberOfCars) {
        List<Car> collect = Stream.generate(Car::new)
                                  .limit(numberOfCars)
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
}
