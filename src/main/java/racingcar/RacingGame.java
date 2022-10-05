package racingcar;

import exception.CustomException;
import racingcar.exception.RacingCarErrorCode;

import java.util.List;

public class RacingGame {
    public static List<Car> race(int carNumber, int moveNumber) {
        validateMoveNumber(moveNumber);
        RacingCars cars = RacingCars.create(carNumber);
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
}
