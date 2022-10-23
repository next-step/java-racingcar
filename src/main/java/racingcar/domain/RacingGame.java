package racingcar.domain;

import exception.CustomException;
import racingcar.exception.RacingCarErrorCode;
import racingcar.generator.RandomNumberGenerator;

import java.util.List;

public class RacingGame {

    private final RacingCars racingCars;

    public RacingGame(String carNames) {
        this.racingCars = RacingCars.create(carNames);
    }

    public List<Car> race(int moveNumber) {
        validateMoveNumber(moveNumber);
        for (int i = 0; i < moveNumber; i++) {
            racingCars.moving(new RandomNumberGenerator());
        }
        return racingCars.copy();
    }

    private void validateMoveNumber(int moveNumber) {
        if (moveNumber < 0) {
            throw new CustomException(RacingCarErrorCode.MOVE_NUMBER_BAD_REQUEST);
        }
    }

    public List<Car> getWinner() {
        return racingCars.getWinners();
    }
}
