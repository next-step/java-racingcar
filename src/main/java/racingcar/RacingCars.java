package racingcar;

import exception.CustomException;
import racingcar.exception.RacingCarErrorCode;
import racingcar.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCars {

    private static final int MINIMUM_VALUE = 4;

    private final List<Car> cars;

    private RacingCars(String[] names) {
        validateArr(names);
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.from(name));
        }
    }

    public static RacingCars create(String[] names) {
        return new RacingCars(names);
    }

    private static void validateArr(String[] names) {
        if (names.length == 0) {
            throw new CustomException(RacingCarErrorCode.CAR_NUMBER_BAD_REQUEST);
        }
    }

    public void moving(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            if (isValidNumber(numberGenerator.generate())) {
                car.moveForward();
            }
        }
    }

    private boolean isValidNumber(int number) {
        return number >= MINIMUM_VALUE;
    }

    public List<Car> copy() {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(Car.from(car));
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
