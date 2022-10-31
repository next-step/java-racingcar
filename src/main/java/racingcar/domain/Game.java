package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.ExceptionMessageUtils;

public final class Game {

    private final Cars cars;
    private final PositiveNumber tryNo;
    private PositiveNumber tryCount;

    public Game(final Cars cars, final PositiveNumber tryNo) {
        validateCars(cars);
        validateTryNo(tryNo);
        this.cars = cars;
        this.tryNo = tryNo;
        this.tryCount = PositiveNumber.ONE;
    }

    private static void validateCars(final Cars cars) {
        if (cars == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "Cars cannot be null"));
        }
    }

    private static void validateTryNo(final PositiveNumber tryNo) {
        if (tryNo == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "TryNo cannot be null"));
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

    public List<CarName> getWinnerCarNames() {
        if (!isGameOver()) {
            return Collections.emptyList();
        }
        return cars.getFarthestMovedCars().stream()
            .map((Car::getName))
            .collect(Collectors.toUnmodifiableList());
    }

    private static CarStatus mapToCarStatus(final Car car) {
        return new CarStatus(car.getName(), car.getDistance());
    }

}
