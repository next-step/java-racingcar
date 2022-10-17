package racingcar;

import exception.CustomException;
import racingcar.exception.RacingCarErrorCode;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingStadium {

    private RacingCars racingCars;

    public RacingStadium(String carNames) {
        this.racingCars = RacingCars.create(carNames);
    }

    public void race(int moveNumber) {
        validateMoveNumber(moveNumber);
        for (int i = 0; i < moveNumber; i++) {
            racingCars.moving(new RandomNumberGenerator());
        }
    }

    private void validateMoveNumber(int moveNumber) {
        if (moveNumber < 0) {
            throw new CustomException(RacingCarErrorCode.MOVE_NUMBER_BAD_REQUEST);
        }
    }

    public void matchResult() {
        RacingCarView.printRacingCar(racingCars.copy());
    }

    public void awards() {
        RacingCarView.printWinner(racingCars.getWinners());
    }
}
