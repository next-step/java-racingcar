package racingcar.model;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private NumberGenerator numberGenerator;
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this(cars, new RandomGenerator());
    }

    Cars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public static Cars from(List<String> names) {
        validateCarSize(names);
        List<Car> cars = names.stream().map(Car::of).collect(Collectors.toList());
        return new Cars(cars);
    }

    private static void validateCarSize(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("자동차는 2대이상이어야 합니다.");
        }
    }

    public Cars move() {
        for (Car car : cars) {
            car.move(numberGenerator.getNumber());
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}