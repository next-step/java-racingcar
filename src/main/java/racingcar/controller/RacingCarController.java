package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    private static final String INPUT_COUNT_ERROR_MESSAGE = "0 이상의 수를 입력해주세요.";

    public static void start() {
        int carCount = getRacingCarCount();
        int attemptCount = getAttemptCount();
        Round round = Round.create(InputView.inputAttemptCount());

        RacingCars racingCars = createRacingCar(carCount);
        while (round.checkRound()) {
            racingCars.move();
            ResultView.printStatus(racingCars);
            round = round.decrease();
        }
    }

    private static int getRacingCarCount() {
        return validateCount(InputView.inputCarCount());
    }


    private static int validateCount(int count) {
        if (count <= 0) {
            throw new IllegalStateException(INPUT_COUNT_ERROR_MESSAGE);
        }
        return count;
    }

    private static RacingCars createRacingCar(int carCount) {
        return RacingCars.create(carCount);
    }
}
