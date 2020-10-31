package step3.controller;

import step3.domain.RandomMoveStrategy;
import step3.dto.RacingGameDTO;
import step3.exception.MinimumTryCountException;
import step3.service.RacingGame;

public class GameController {


    public void startRacingGame() {
        int carCount = InputController.putCarCount();
        int tryCount = InputController.putTryCount();


        OutputController.endResult();

        RacingGame racingGame = new RacingGame(new RacingGameDTO(carCount,tryCount), new RandomMoveStrategy());
        for (int i = 0; i < tryCount; i++) {
            OutputController.runResult(racingGame.getGameRoundResult());
        }
    }


}
