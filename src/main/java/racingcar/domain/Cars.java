package racingcar.domain;

import racingcar.util.ValidateUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final String VALID_MIN_NO = "최소 자동차 1대 이상입니다.";
    private final List<Car> cars;

    public Cars(int no) {
        this.cars = Stream.generate(() -> new Car())
                .limit(no)
                .collect(Collectors.toList());
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private void validateCars(int carCount) {
        if (ValidateUtils.validateMin(carCount)) {
            throw new IllegalArgumentException(VALID_MIN_NO);
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
