package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.domain.dto.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int trialCount = InputView.inputTrialCount();

        RacingCarGame racingCarGame = RacingCarGame.from(carCount);
        RacingResult result = racingCarGame.executeRacing(trialCount);

        OutputView.printCarsPositionByRounds(result);
    }
}
