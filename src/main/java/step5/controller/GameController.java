package step5.controller;

import step5.domain.RandomMoveStrategy;
import step5.dto.RacingGameConditionDTO;
import step5.dto.RacingGameConditionMoveStrategyDTO;
import step5.service.RacingGame;

public class GameController {


    public void startRacingGame() {
        String carNames = InputController.putCarCount();

        int tryCount = InputController.putTryCount();

        OutputController.printEndResult();

        RacingGame racingGame = RacingGame.of(
                RacingGameConditionMoveStrategyDTO.of(
                        RacingGameConditionDTO.of(carNames, tryCount), new RandomMoveStrategy()));

        for (int i = 0; i < tryCount; i++) {
            OutputController.runResult(racingGame.runRound());
        }

        OutputController.printWinnerResult(racingGame.getTopPositionCarNames());
    }
}
