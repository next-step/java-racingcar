package step5.controller;

import step5.dto.RacingGameConditionDTO;
import step5.service.RacingGame;
import step5.utils.RandomUtil;
import step5.view.InputView;
import step5.view.OutputView;

public class GameController {


    public void startRacingGame() {
        String carNames = InputView.putCarCount();

        int tryCount = InputView.putTryCount();

        OutputView.printEndResult();

        RacingGame racingGame = RacingGame.of(
                        RacingGameConditionDTO.of(carNames, tryCount));

        for (int i = 0; i < tryCount; i++) {
            OutputView.runResult(racingGame.runRound(RandomUtil.generateRandomNumber()));
        }

        OutputView.printWinnerResult(racingGame.getTopPositionCarNames());
    }
}
