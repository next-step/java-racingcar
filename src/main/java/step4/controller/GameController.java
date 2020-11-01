package step4.controller;

import step4.domain.RandomMoveStrategy;
import step4.dto.RacingGameConditionDTO;
import step4.service.RacingGame;

public class GameController {


    public void startRacingGame() {
        String carNames = InputController.putCarCount();
        int tryCount = InputController.putTryCount();


        OutputController.printEndResult();

        RacingGame racingGame = new RacingGame(new RacingGameConditionDTO(carNames,tryCount), new RandomMoveStrategy());
        for (int i = 0; i < tryCount; i++) {
            OutputController.runResult(racingGame.getGameRoundResult());
        }

        OutputController.printWinnerResult(racingGame.getGameEndResult());
    }


}
