package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    private static String INPUT_COUNT_ERROR_MESSAGE = "0 이상의 수를 입력해주세요.";

    public static RacingCarController init() {
        return new RacingCarController();
    }

    public void start() {
        int carCount = getRacingCarCount();
        int attemptCount = getAttemptCount();

        RacingCars racingCars = createRacingCar(carCount);
        for (int i = 0; i < attemptCount; i++) {
            racingCars.move();
            ResultView.printStatus(racingCars);
        }
    }

    private int getRacingCarCount() {
        return validateCount(InputView.inputCarCount());
    }

    private int getAttemptCount() {
        return validateCount(InputView.inputAttemptCount());
    }

    private int validateCount(int count) {
        if (count <= 0) {
            throw new IllegalStateException(INPUT_COUNT_ERROR_MESSAGE);
        }
        return count;
    }

    private RacingCars createRacingCar(int carCount) {
        return RacingCars.create(carCount);
    }
}
