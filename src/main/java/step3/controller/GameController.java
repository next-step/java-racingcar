package step3.controller;

import step3.exception.MinimumTryCountException;
import step3.service.RacingGame;

public class GameController {

    private static final int MIN_TRY_COUNT = 1;

    public void startRacingGame() {
        int carCount = InputController.putCarCount();
        int tryCount = InputController.putTryCount();
        validTryCount(tryCount);

        OutputController.endResult();
        RacingGame racingGame = new RacingGame(carCount);
        for(int i =0 ; i < tryCount ; i++){
            OutputController.runResult(racingGame.getGameRoundResult());
        }
    }

    private void validTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new MinimumTryCountException();
        }

    }
}
