package racingcar;

import exception.CustomException;
import racingcar.exception.RacingCarErrorCode;

import java.util.List;

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
}
