package racingcar.domain;

import racingcar.util.ValidateUtils;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Cars {
    private static final String NAME_SEPARATOR = ",";
    private static final String VALID_SEPARATOR_MESSAGE = "자동차 이름 구분자 쉼표(,)가 없습니다.";
    private static final String VALID_MAX_POSITION_MESSAGE = "최대 이동 차가 존재하지 않습니다.";
    private final List<Car> cars;

    public Cars(String names) {
        validateCars(names);
        this.cars = Arrays.stream(names.split(NAME_SEPARATOR))
                .map(name -> new Car(new Name(name)))
                .collect(toList());
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private void validateCars(String names) {
        ValidateUtils.validateEmpty(names);
        validateSeparator(names);
    }

    private void validateSeparator(String names) {
        if (!names.contains(NAME_SEPARATOR)) {
            throw new IllegalArgumentException(VALID_SEPARATOR_MESSAGE);
        }
    }

    public void run() {
        for (Car car : cars) {
            car.play(new RandomNumber());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    private int getMaxposition() {
        return this.cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(VALID_MAX_POSITION_MESSAGE));
    }

    public List<Car> getWinners() {
        return this.cars.stream()
                .filter(car -> car.isEqualsPosition(getMaxposition()))
                .collect(toList());
    }
}
