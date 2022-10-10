package racingGame;

import racingGame.strategy.MoveAbleRandomNumber;
import racingGame.view.InputView;
import racingGame.view.ResultView;

public class RacingApplication {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new MoveAbleRandomNumber());
        ResultView.racingResult(racingGame.carTryMove(InputView.tryCount()));
    }
}
