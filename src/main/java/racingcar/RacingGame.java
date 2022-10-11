package racingcar;

import exception.CustomException;
import racingcar.exception.RacingCarErrorCode;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {

    private static final String REGEX = ",";

    public static List<Car> race(String carNames, int moveNumber) {
        validateMoveNumber(moveNumber);
        String[] names = splitNames(carNames);
        RacingCars cars = RacingCars.create(names);
        for (int i = 0; i < moveNumber; i++) {
            cars.moving(new RandomNumberGenerator());
        }
        return cars.copy();
    }

    private static void validateMoveNumber(int moveNumber) {
        if (moveNumber < 0) {
            throw new CustomException(RacingCarErrorCode.MOVE_NUMBER_BAD_REQUEST);
        }
    }

    private static String[] splitNames(String carNames) {
        return carNames.split(REGEX);
    }

    public static List<Car> getWinners(List<Car> cars) {
        Integer maxPosition = getMaxPosition(cars);

        return cars.stream()
                .filter(car -> Objects.equals(car.getLocation(), maxPosition))
                .collect(Collectors.toList());
    }

    private static Integer getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
