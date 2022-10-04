package racingcar;

import exception.CustomException;

public class RacingGame {
    public static void race(int carNumber, int moveNumber) {
        validateMoveNumber(moveNumber);
        RacingCars cars = RacingCars.create(carNumber);
        for (int i = 0; i < moveNumber; i++) {
            cars.moving(new RandomNumberGenerator());
            cars.print();
        }
    }

    private static void validateMoveNumber(int moveNumber) {
        if (moveNumber < 0) {
            throw new CustomException(RacingCarErrorCode.MOVE_NUMBER_BAD_REQUEST);
        }
    }
}
