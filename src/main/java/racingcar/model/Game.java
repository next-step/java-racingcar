package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.ExceptionMessageUtils;

public final class Game {

    private static final String CAR_NAME_DELIMITER = ",";

    private final PositiveNumber tryNo;
    private PositiveNumber tryCount;
    private final Cars cars;

    public Game(final String carNames, final String tryNo) {
        validateCarNames(carNames);
        this.cars = new Cars(mapToCarList(carNames.split(CAR_NAME_DELIMITER)));
        this.tryNo = new PositiveNumber(tryNo);
        this.tryCount = PositiveNumber.ONE;
    }

    private void validateCarNames(final String carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "Car names cannot be null"));
        }
        if (carNames.isBlank()) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "Car names cannot be blank"));
        }
    }

    public void play() {
        if (isGameOver()) {
            return;
        }
        cars.move();
        increaseTryCount();
    }

    private void increaseTryCount() {
        tryCount = tryCount.plus(PositiveNumber.ONE);
    }

    public boolean isGameOver() {
        return tryCount.isGreaterThan(tryNo);
    }

    public List<CarStatus> getCarStatuses() {
        return cars.getCars().stream()
            .map(Game::mapToCarStatus)
            .collect(Collectors.toUnmodifiableList());
    }

    public List<Winner> getWinners() {
        if (!isGameOver()) {
            return Collections.emptyList();
        }
        return cars.getFarthestMovedCars().stream()
            .map(Game::mapToWinner)
            .collect(Collectors.toUnmodifiableList());
    }

    private static List<Car> mapToCarList(final String[] carNames) {
        return Arrays.stream(carNames)
            .map((carName) -> CarFactory.getDefaultCar(carName.strip()))
            .collect(Collectors.toUnmodifiableList());
    }

    private static CarStatus mapToCarStatus(final Car car) {
        return new CarStatus(car.getName(), car.getDistance());
    }

    private static Winner mapToWinner(final Car car) {
        return new Winner(car.getName());
    }
}
