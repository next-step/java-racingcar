package step4.controller;

import step4.domain.RandomMoveStrategy;
import step4.dto.RacingGameConditionDTO;
import step4.dto.RacingGameConditionMoveStrategyDTO;
import step4.service.RacingGame;

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
