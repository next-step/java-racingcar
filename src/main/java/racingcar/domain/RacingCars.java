package racingcar.domain;

import racingcar.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {

    private static final int MINIMUM_VALUE = 4;
    private static final String REGEX = ",";

    private final List<Car> cars;

    private RacingCars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.from(name));
        }
    }

    public static RacingCars create(String names) {
        return new RacingCars(splitNames(names));
    }

    private static String[] splitNames(String carNames) {
        return carNames.split(REGEX);
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
        return cars.stream()
                .map(Car::from)
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        Integer maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> Objects.equals(car.getLocation(), maxPosition))
                .collect(Collectors.toList());
    }

    private Integer getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(NoSuchElementException::new);
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
