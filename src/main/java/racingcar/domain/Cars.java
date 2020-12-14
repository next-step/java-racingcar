package racingcar.domain;

import racingcar.util.ValidateUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {
    private static final String NAME_SEPARATOR = ",";
    private static final String VALID_SEPARATOR_MESSAGE = "자동차 이름 구분자 쉼표(,)가 없습니다.";
    private final List<Car> cars;

    public Cars(String names) {
        validateCars(names);
        this.cars = Arrays.stream(names.split(NAME_SEPARATOR))
                .map(name -> new Car(new Name(name)))
                .collect(toList());
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
}
