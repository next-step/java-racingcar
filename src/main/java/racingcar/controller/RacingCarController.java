package racingcar.controller;

import racingcar.domain.Participants;
import racingcar.domain.RacingCarGame;
import racingcar.domain.dto.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public static void main(String[] args) {
        String participantsNames = InputView.inputCarCount();
        int trialCount = InputView.inputTrialCount();

        RacingCarGame racingCarGame = RacingCarGame.from(Participants.from(participantsNames));
        RacingResult result = racingCarGame.executeRacing(trialCount);

        OutputView.printCarsPositionByRounds(result);
    }
}
