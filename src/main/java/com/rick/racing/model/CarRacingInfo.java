package com.rick.racing.model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarRacingInfo {

    private static final String EXCEPTION_MESSAGE_MINIMUM_CAR_NAME_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String EXCEPTION_MESSAGE_MINIMUM_TRY_COUNT = "시도 수는 0보다 커야 합니다.";

    private final List<Car> cars;
    private final int tryCount;

    private CarRacingInfo(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public static CarRacingInfo create(List<String> carNames, int tryCount) {
        carNames.forEach(CarRacingInfo::validateName);

        if (tryCount <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MINIMUM_TRY_COUNT);
        }

        List<Car> cars = carNames.stream()
            .map(Car::create)
            .collect(Collectors.toList());

        return new CarRacingInfo(cars, tryCount);
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MINIMUM_CAR_NAME_LENGTH);
        }
    }

    public List<Car> cars() {
        return cars;
    }

    public int tryCount() {
        return tryCount;
    }

    public List<Car> winners() {
        Optional<Car> optionalWinnerCar = cars.stream()
            .max(Car::compareTo);

        if (!optionalWinnerCar.isPresent()) {
            return Collections.emptyList();
        }

        Car winnerCar = optionalWinnerCar.get();

        return cars.stream()
            .filter(car -> car.isPositionAt(winnerCar))
            .collect(Collectors.toList());
    }
}
